package com.ecommerce.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.constants.IntentConstants
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.databinding.FragmentProductlistBinding
import com.ecommerce.app.ui.adapters.ProductPageAdapter
import com.ecommerce.app.ui.viewmodels.ProductListViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.autoCleared
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() ,ProductPageAdapter.CardItemListener{

    private val productListViewModel: ProductListViewModel by viewModels()
    private var binding: FragmentProductlistBinding by autoCleared()
    private lateinit var adapter: ProductPageAdapter
    private var productListItem = ArrayList<ProductItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductlistBinding.inflate(inflater, container, false)
        //val toolbar: Toolbar = root.findViewById(R.id.toolbar)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()
        setupRecyclerView()
        setupObservers()
        productListViewModel.getProducts(null)
       // productListViewModel.getProducts(null)
    }

    private fun setupRecyclerView() {
        adapter = ProductPageAdapter(requireContext(),this)
        binding.recyclerView.layoutManager =  GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
    }

    private fun setOnClickListener()
    {
        binding.sorLL.setOnClickListener {

            // on below line we are creating a new bottom sheet dialog.
            val dialog = BottomSheetDialog(requireActivity())
            val view = layoutInflater.inflate(R.layout.bottom_sheet_sort_dialog, null)

            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
        }
    }
    override fun onClickedCard(selectedProduct: ProductItem) {
        DebugHandler.log("Hello Fragment Product=="+selectedProduct.id)
        findNavController().navigate(R.id.action_productListFragment_to_productDetailFragment,
            bundleOf( IntentConstants.PRODUCT_DETAILS to  GsonHelper.toJson(selectedProduct))
        )

    }

    private fun setupObservers(){
        setProgressBar(true)

        productListViewModel.response.observe(viewLifecycleOwner, Observer {

            setProgressBar(false)
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