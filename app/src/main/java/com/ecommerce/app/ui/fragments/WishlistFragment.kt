package com.ecommerce.app.ui.fragments

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.databinding.FragmentProductListBinding
import com.ecommerce.app.databinding.FragmentWishlistBinding
import com.ecommerce.app.databinding.FragmentWishlistListDialogBinding
import com.ecommerce.app.ui.adapters.ProductListAdapter
import com.ecommerce.app.ui.adapters.ProductPageAdapter
import com.ecommerce.app.ui.viewmodels.ProductListViewModel
import com.ecommerce.app.ui.viewmodels.WishlistViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WishlistFragment : Fragment() {

    private val wishlistViewModel: WishlistViewModel by viewModels()
    private var binding: FragmentWishlistBinding by autoCleared()
    private lateinit var adapter: ProductPageAdapter
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

        setupRecyclerView()
        setupObserversNew()
       // productListViewModel.getProducts(null)
    }

    private fun setupRecyclerView() {
        adapter = ProductPageAdapter(requireContext())
        binding.recyclerView.layoutManager =  GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
    }
    private fun setupObserversNew(){

        wishlistViewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitData(lifecycle,it)
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
}