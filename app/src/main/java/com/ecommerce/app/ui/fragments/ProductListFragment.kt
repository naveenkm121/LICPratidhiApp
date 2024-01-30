package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.databinding.FragmentProductListBinding
import com.ecommerce.app.ui.adapters.ProductListAdapter

import com.ecommerce.app.ui.viewmodels.ProductListViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private val productListViewModel: ProductListViewModel by viewModels()
    private var binding: FragmentProductListBinding by autoCleared()
    private lateinit var adapter: ProductListAdapter
    private var productListItem = ArrayList<ProductItem>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()
        productListViewModel.getProducts(null)
    }

    private fun setupRecyclerView() {
        adapter = ProductListAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }


    private fun setupObservers() {
        productListViewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.SUCCESS -> {
                   // setProgressBar(false)
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
                   // setProgressBar(false)
                    DebugHandler.log("Error Naveen== "+it.message)
                    if (it.message?.contains("401") == true) {
                      //  Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                      //  activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };

                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                ResourceViewState.Status.LOADING ->{

                }
                    //setProgressBar(true)
            }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }
}