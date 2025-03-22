package com.licapps.bmmis.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.Constants
import com.licapps.bmmis.constants.StringConstants
import com.licapps.bmmis.data.model.Wish
import com.licapps.bmmis.data.model.WishTag
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.ui.adapters.WishesAdapter
import com.licapps.bmmis.ui.adapters.WishesAdapter.*
import com.licapps.bmmis.ui.adapters.WishesTagsRVAdapter
import com.licapps.bmmis.ui.adapters.WishesTagsRVAdapter.*
import com.licapps.bmmis.ui.viewmodels.WishesViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import com.licapps.bmmis.databinding.WishesFragmentBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WishesFragment : Fragment(), WishItemListener,
    WishTagsItemListener {

    private var binding: WishesFragmentBinding by autoCleared()
    private val viewModel: WishesViewModel by viewModels()
    private lateinit var adapter: WishesAdapter
    private lateinit var wishesTagsRVAdapter: WishesTagsRVAdapter
    private lateinit var customAlertDialogView: View
    private lateinit var materialAlertDialogBuilder: MaterialAlertDialogBuilder
    private val apiRequest = CommonReq()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = WishesFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
        apiRequest.branch=(activity as NewHomeActivity).branch
        viewModel.getWishesList(apiRequest);
        materialAlertDialogBuilder = MaterialAlertDialogBuilder(requireContext())
    }

    private fun setupRecyclerView() {
        adapter = WishesAdapter(this)
        wishesTagsRVAdapter = WishesTagsRVAdapter(this)
        binding.wishesRV.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.wishesRV.adapter = adapter
        binding.tagsWishesRV.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        binding.tagsWishesRV.adapter = wishesTagsRVAdapter
    }

    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data!=null&&!it.data.data.isNullOrEmpty()) {
                        var categoryList = ArrayList<String>()
                        var i: Int = 0
                        wishesTagsRVAdapter.items.clear()
                        wishesTagsRVAdapter.items.add(WishTag(i++, StringConstants.ALL,true))
                        it.data.data.forEach { itInner ->
                            if (!categoryList.contains(itInner.category)) {
                                wishesTagsRVAdapter.items.add(WishTag(i++, itInner.category))
                                categoryList.add(itInner.category)
                            }
                        }
                        wishesTagsRVAdapter.notifyDataSetChanged()
                        adapter.setItems(ArrayList(it.data.data))
                    }
                }
                Resource.Status.ERROR -> {
                    setProgressBar(false)
                    if(it.message?.contains("401")==true){
                        Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                    }
                    else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->
                    setProgressBar(true)
            }
        })
    }

    override fun onClickedWish(wish: Wish, x: Float, y: Float) {
        var dialog = MaterialAlertDialogBuilder(requireContext())
            .setView(R.layout.wish_detail_fragment)
            .setPositiveButton(
                "Share"
            ) { dialogInterface, i -> customAlertDialogView }
            .setNegativeButton(
                "CANCEL"
            ) { dialogInterface, i -> }.create()

        dialog.window!!.decorView.pivotY = x
        dialog.window!!.decorView.pivotY = y
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation
        dialog.show()
        Glide.with(binding.root)
            .asBitmap()
            .load(Constants.BASE_URL + wish.imageurl)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(
                    bitmap: Bitmap,
                    transition: Transition<in Bitmap>?
                ) {
                    dialog.findViewById<ImageView>(R.id.wishImageIV)!!.setImageBitmap(bitmap)
                    dialog.getButton(-1).setOnClickListener(View.OnClickListener {

                        val shareIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(
                                Intent.EXTRA_STREAM,
                                CommonUtility.getImageUriFromBitmap(context, bitmap)
                            )
                            type = "image/jpeg"
                        }
                        startActivity(
                            Intent.createChooser(
                                shareIntent,
                                resources.getText(R.string.send_to)
                            )
                        )
                    })

                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // this is called when imageView is cleared on lifecycle call or for
                    // some other reason.
                    // if you are referencing the bitmap somewhere else too other than this imageView
                    // clear it here as you can no longer have the bitmap
                }
            })

    }


    override fun onClickedWishTag(wishTag: WishTag) {


        for (i in wishesTagsRVAdapter.items) {
            if ((wishTag.id == wishesTagsRVAdapter.items[i.id].id) && !wishTag.isSelected) {
                wishesTagsRVAdapter.items.forEach { it.isSelected = false }
                wishesTagsRVAdapter.items[i.id].isSelected =
                    !wishesTagsRVAdapter.items[i.id].isSelected

                val list = viewModel.response.value?.data?.data
                var filterList = ArrayList<Wish>()
                if (wishTag.value == "All")
                    list?.forEach { filterList.add(it) }
                else {
                    if (list != null)
                        for (wishItem in list) {
                            if (wishItem.category == wishTag.value) {
                                filterList.add(wishItem)
                            }
                        }

                }
                adapter.setItems(filterList)
                wishesTagsRVAdapter.notifyDataSetChanged()
            }
        }

    }
    private fun setProgressBar(b: Boolean) {
        if(!b){
            binding.progressBar.shimmerLayout.visibility = View.GONE
            binding.progressBar.shimmerLayout.showShimmer(false)
        }
        else
        {
            binding.progressBar.shimmerLayout.visibility = View.VISIBLE
            binding.progressBar.shimmerLayout.showShimmer(true)
        }
    }
}


