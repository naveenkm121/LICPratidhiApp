package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.constants.IntentConstants
import com.ecommerce.app.data.category.Category
import com.ecommerce.app.data.category.SubCategory
import com.ecommerce.app.data.category.SubSubCategory
import com.ecommerce.app.databinding.FragmentSubCategoryBinding
import com.ecommerce.app.ui.activities.HomeActivity
import com.ecommerce.app.ui.adapters.SubCategoryAdapter
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SubCategoryFragment : Fragment(), CommonSelectItemRVListerner {

    private var binding: FragmentSubCategoryBinding by autoCleared()
    private lateinit var adapter: SubCategoryAdapter
    private lateinit var selectedCategory: Category


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            val categoriesJson = bundle.getString(IntentConstants.CATEGORY_ITEM)
            selectedCategory = GsonHelper.fromJson(categoriesJson, Category::class.java)!!
            // Use the value as needed
        }

        (activity as? HomeActivity)?.hideBottomNavigationView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        adapter = SubCategoryAdapter(this)
        adapter.setItem(selectedCategory.subCategories)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }

    private fun launchProductListScreen() {
        findNavController().navigate(
            R.id.action_categoryFragment_to_productListFragment
        )
    }

    override fun onSelectItemRVType(selectedItem: Any) {

        when (selectedItem) {

            is SubCategory -> {
                var selectedSubCategoryIndex = selectedCategory.subCategories.indexOf(selectedItem)
                selectedCategory.subCategories.get(selectedSubCategoryIndex).isSelected =
                    !selectedItem.isSelected
                adapter.notifyItemChanged(selectedSubCategoryIndex)
            }

            is SubSubCategory -> {
                launchProductListScreen()
            }

            else -> println("obj is SubCategory a String nor an SubSubCategory")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }

}