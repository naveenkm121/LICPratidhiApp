package com.ecommerce.app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.data.filter.FilterRes
import com.ecommerce.app.databinding.FragmentProductFilterBinding
import com.ecommerce.app.ui.adapters.FilterItemsAdapter
import com.ecommerce.app.ui.adapters.FilterTypeAdapter
import com.ecommerce.app.utils.CommonUtility
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.autoCleared


class ProductFilterFragment : Fragment() {

    private var binding:FragmentProductFilterBinding by autoCleared()
    private lateinit var filterTypeAdapter:FilterTypeAdapter
    private lateinit var  filterItemsAdapter:FilterItemsAdapter
    private lateinit var filterRes: FilterRes
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentProductFilterBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupFilterData()
        setupRecyclerView()

    }
    private fun setupToolbar() {
        val toolbar: Toolbar = requireActivity().findViewById<View>(R.id.toolbar) as Toolbar
        toolbar.setTitle(getString(R.string.filter))

    }

    private fun setupRecyclerView() {
        filterTypeAdapter=FilterTypeAdapter()
        filterTypeAdapter.setItem(filterRes.filters)
        binding.filterTypeRV.layoutManager = LinearLayoutManager(requireContext())
        binding.filterTypeRV.adapter=filterTypeAdapter


        filterItemsAdapter= FilterItemsAdapter()
        filterItemsAdapter.setItem(filterRes.filters.get(2).filterItems)
        binding.filterItemsRV.layoutManager=LinearLayoutManager(requireContext())
        binding.filterItemsRV.adapter=filterItemsAdapter

    }
    private fun setupFilterData(){
        val filterJsonString = CommonUtility.getJsonDataFromAsset(requireContext(), "filter.json")
        filterRes=GsonHelper.fromJson(filterJsonString,FilterRes::class.java)!!
        DebugHandler.log("FilterData =="+filterRes)
        filterRes.filters.get(3).isSelected=true


    }




}