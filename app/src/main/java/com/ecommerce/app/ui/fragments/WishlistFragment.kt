package com.ecommerce.app.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.constants.IntentConstants
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.databinding.FragmentWishlistBinding
import com.ecommerce.app.ui.adapters.ProductListAdapter
import com.ecommerce.app.ui.viewmodels.WishlistViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WishlistFragment : Fragment(),ProductListAdapter.CardItemListener {

    private val wishlistViewModel: WishlistViewModel by viewModels()
    private var binding: FragmentWishlistBinding by autoCleared()
    private lateinit var adapter: ProductListAdapter
    private var productListItem = ArrayList<ProductItem>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWishlistBinding.inflate(inflater, container, false)
        //val toolbar: Toolbar = root.findViewById(R.id.toolbar)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setHasOptionsMenu(true)
        setupRecyclerView()
        setupObservers()
        wishlistViewModel.getProducts(null)
    }

    private fun setupRecyclerView() {
        adapter = ProductListAdapter(requireContext(),this)
        binding.recyclerView.layoutManager =  GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        wishlistViewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.SUCCESS -> {
                    setProgressBar(false)
                   if (it.data != null && it.data.status == 1) {
                        if (it.data.data.isNotEmpty()) {

                            productListItem = it.data.data as ArrayList<ProductItem>
                            adapter.setItems(productListItem)
                        } else {
                            //binding.noResultIV.visibility = View.VISIBLE
                            Toast.makeText(requireContext(), it.data.message, Toast.LENGTH_LONG).show()
                        }
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.ERROR -> {
                    setProgressBar(false)
                    DebugHandler.log("Error Naveen== "+it.message)
                    if (it.message?.contains("401") == true) {
                      //  Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                      //  activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };

                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.LOADING ->{
                    setProgressBar(true)
                }
            }
        })

    }



    private fun setProgressBar(b: Boolean) {
        if (!b) {
           // binding.progressBarShim.shimmerLayout.visibility = View.GONE
            binding.progressBar.visibility = View.GONE
           // binding.progressBarShim.shimmerLayout.showShimmer(false)
        } else {
           // binding.progressBarShim.shimmerLayout.visibility = View.VISIBLE
            binding.progressBar.visibility = View.VISIBLE
           // binding.progressBarShim.shimmerLayout.showShimmer(true)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }

    override fun onClickedCard(selectedProduct: ProductItem) {
        DebugHandler.log("Hello Fragment Product=="+selectedProduct.id)
        findNavController().navigate(R.id.action_productListFragment_to_productDetailFragment,
            bundleOf( IntentConstants.PRODUCT_DETAILS to  GsonHelper.toJson(selectedProduct))
        )

    }
}