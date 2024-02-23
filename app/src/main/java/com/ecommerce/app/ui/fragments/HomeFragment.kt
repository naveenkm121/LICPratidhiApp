package com.ecommerce.app.ui.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.data.category.Category
import com.ecommerce.app.data.category.CategoryRes
import com.ecommerce.app.databinding.FragmentHomeBinding
import com.ecommerce.app.ui.adapters.CommonRVAdapter
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.SaveSharedPreference
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(),CommonSelectItemRVListerner {
    private var binding: FragmentHomeBinding by autoCleared()
    private lateinit var topCategoryAdapter: CommonRVAdapter
    private lateinit var categoryRes: CategoryRes



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setHasOptionsMenu(true)
        DebugHandler.log("Hello Bootom")
        setupCategoryRecyclerView()

    }

    private fun setupCategoryRecyclerView() {
        categoryRes= SaveSharedPreference.getCategoryResValue(requireContext())!!
        topCategoryAdapter = CommonRVAdapter(ScreenName.FRAGMENT_HOME_TOP_CATEGORY.value,this)
        topCategoryAdapter.setItems(categoryRes.data as ArrayList<Category>)
        binding.topCategoryRV.layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        binding.topCategoryRV.adapter = topCategoryAdapter
    }



    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }

    override fun onSelectItemRVType(selectedItem: Any) {
        DebugHandler.log("Hello categoryclick")
    }


}