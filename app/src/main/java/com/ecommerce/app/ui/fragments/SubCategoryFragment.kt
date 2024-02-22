package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.data.category.CategoryRes
import com.ecommerce.app.data.filter.FilterRes
import com.ecommerce.app.data.product.Category
import com.ecommerce.app.databinding.FragmentCategoryBinding
import com.ecommerce.app.databinding.FragmentSubCategoryBinding
import com.ecommerce.app.ui.adapters.CommonRVAdapter
import com.ecommerce.app.ui.adapters.SubCategoryAdapter
import com.ecommerce.app.ui.adapters.SubCategoryExpandableAdapter
import com.ecommerce.app.ui.adapters.WishlistAdapter
import com.ecommerce.app.ui.viewmodels.CategoryViewModel
import com.ecommerce.app.utils.CommonUtility
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubCategoryFragment : Fragment() {

    private var binding: FragmentSubCategoryBinding by autoCleared()
    private lateinit var adapter: SubCategoryAdapter
    private lateinit var categoryRes: CategoryRes


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        val categoriesJson=CommonUtility.getJsonDataFromAsset(requireContext(), "categories.json")
        categoryRes = GsonHelper.fromJson(categoriesJson, CategoryRes::class.java)!!


       // adapter = SubCategoryExpandableAdapter(categoryRes.data.get(0).subCategories)
        adapter=SubCategoryAdapter()
        binding.recyclerView.layoutManager =  LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        adapter.setItem(categoryRes.data.get(0).subCategories)
    }

}