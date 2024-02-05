package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ecommerce.app.R
import com.ecommerce.app.constants.IntentConstants
import com.ecommerce.app.data.product.ProductImage
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.databinding.FragmentProductDetailBinding
import com.ecommerce.app.ui.adapters.ProductImageViewPagerAdapter
import com.ecommerce.app.ui.adapters.ProductPageAdapter
import com.ecommerce.app.ui.viewmodels.ProductDetailViewModel
import com.ecommerce.app.ui.viewmodels.WishlistViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
import com.google.android.material.tabs.TabLayoutMediator

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class ProductDetailFragment : Fragment() {
    private val viewModel: ProductDetailViewModel by viewModels()
    private var binding:FragmentProductDetailBinding by autoCleared()
    private lateinit var adapter: ProductImageViewPagerAdapter
    private var productImageList = ArrayList<ProductImage>()
    private  var productId: Int=0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentProductDetailBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productId = arguments?.getInt(IntentConstants.PRODUCT_DETAILS)!!
        viewModel.getProductDetailsById(productId)
        setupRecyclerView()
        setupObservers()

    }

    private fun setupRecyclerView() {
        adapter = ProductImageViewPagerAdapter()
        //adapter.setItem(imageList)
        binding.imageViewPager.adapter = adapter

        TabLayoutMediator(binding.circularTabLayout, binding.imageViewPager) { tab, position ->
        }.attach()
    }

    private fun setupObservers(){

        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.SUCCESS -> {
                    //setProgressBar(false)
                    if (it.data != null && it.data.status == 1) {
                       // if (it.data.isNotEmpty()) {

                            productImageList = it.data.data.images as ArrayList<ProductImage>
                            adapter.setItem(productImageList)
//                        } else {
//                            //binding.noResultIV.visibility = View.VISIBLE
//                            Toast.makeText(requireContext(), it.data.message, Toast.LENGTH_LONG).show()
//                        }
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.ERROR -> {
                   // setProgressBar(false)
                    DebugHandler.log("Error Naveen== "+it.message)
                    if (it.message?.contains("401") == true) {
                        //  Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        //  activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };

                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.LOADING ->{
                  //  setProgressBar(true)
                }
            }
///adapter.setItem(it.data!!.data.images)
        })

    }


}

