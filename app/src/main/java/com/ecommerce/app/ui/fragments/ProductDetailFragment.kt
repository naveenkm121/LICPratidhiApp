package com.ecommerce.app.ui.fragments

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.ScaleAnimation
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ecommerce.app.R
import com.ecommerce.app.constants.IntentConstants
import com.ecommerce.app.data.product.ProductImage
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.databinding.FragmentProductDetailBinding
import com.ecommerce.app.ui.adapters.ProductImageViewPagerAdapter
import com.ecommerce.app.ui.viewmodels.ProductDetailViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class ProductDetailFragment : Fragment() {
    private val viewModel: ProductDetailViewModel by viewModels()
    private var binding:FragmentProductDetailBinding by autoCleared()
    private lateinit var adapter: ProductImageViewPagerAdapter
    private lateinit var productDetailPassObj: ProductItem


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
       // productDetailPassObj= GsonHelper.fromJson(arguments?.getString(IntentConstants.PRODUCT_DETAILS)!!,ProductItem::class.java)!!
        val prodId= arguments?.getInt(IntentConstants.PRODUCT_ID)
        val prodBrand= arguments?.getString(IntentConstants.PRODUCT_BRAND).toString()
        viewModel.getProductDetailsById(prodId!!)
        setupToolbar(prodBrand)
        setupRecyclerView()
        setupObservers()

    }

    private fun setupToolbar(title:String) {
        val toolbar: Toolbar = requireActivity().findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.setTitle(title)
    }
    private fun setupRecyclerView() {
        adapter = ProductImageViewPagerAdapter()
        binding.imageViewPager.adapter = adapter
        TabLayoutMediator(binding.circularTabLayout, binding.imageViewPager) { tab, position ->
        }.attach()
    }

    private  fun setupDataToUI(productItem: ProductItem){
        binding.productNameTV.text=productItem.title
        binding.discountPriceTV.text=getString(R.string.input_rs_symbol,productItem.price.toString())
        binding.priceTV.text=getString(R.string.mrp_rs_input,productItem.price.toString())
        binding.discountTV.text="(${productItem.discountPercentage}% OFF)"
        binding.priceTV.setPaintFlags(binding.priceTV.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)

        binding.productDetailTV.text=productItem.description

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadDataWithBaseURL(null, productItem.description, "text/html", "UTF-8", null)
    }



    private fun setupObservers(){

        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.SUCCESS -> {
                    //setProgressBar(false)
                    if (it.data != null && it.data.status == 1) {
                       // if (it.data.isNotEmpty()) {
                            productDetailPassObj=it.data.data
                        var productImageList = it.data.data.images as ArrayList<ProductImage>
                        if(productImageList.isEmpty())productImageList.add(ProductImage(1,1,productDetailPassObj.thumbnail))
                        adapter.setItem(productDetailPassObj.images)
                            setupDataToUI(productDetailPassObj)
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
                          Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        //  activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };

                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.LOADING ->{
                  //  setProgressBar(true)
                }
            }
        })

    }


}

