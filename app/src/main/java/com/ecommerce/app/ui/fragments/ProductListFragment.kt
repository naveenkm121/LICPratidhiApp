package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ecommerce.app.databinding.FragmentProductListBinding
import com.ecommerce.app.ui.viewmodels.ProductListViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    private val productListViewModel: ProductListViewModel by viewModels()
    private var binding: FragmentProductListBinding by autoCleared()


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
        productListViewModel.getProducts(null)
        setupObservers()

    }


    private fun setupObservers() {
        productListViewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.SUCCESS -> {
                   // setProgressBar(false)
                    if(it.data!=null)
                    {
                        DebugHandler.log("Data== "+it.data)
                    }
                   /* if (it.data != null && it.data.status == 1) {
                        if (it.data.data.isNotEmpty()) {

                            bocItemList = it.data.data as ArrayList<BOCItem>
                            addTotalItem()
                            binding.noResultIV.visibility = View.GONE
                            adapter.setItems(bocItemList)
                        } else {
                            binding.noResultIV.visibility = View.VISIBLE

                        }
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()*/

                }
                ResourceViewState.Status.ERROR -> {
                   // setProgressBar(false)
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