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
import com.ecommerce.app.data.filter.FilterRes
import com.ecommerce.app.data.home.HomeRes
import com.ecommerce.app.data.home.ViewType
import com.ecommerce.app.databinding.FragmentHomeBinding
import com.ecommerce.app.ui.adapters.CommonRVAdapter
import com.ecommerce.app.ui.adapters.HomeAdapter
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.CommonUtility
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.SaveSharedPreference
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(),CommonSelectItemRVListerner {
    private var binding: FragmentHomeBinding by autoCleared()
    private lateinit var topCategoryAdapter: CommonRVAdapter
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var categoryRes: CategoryRes
    private lateinit var homeRes: HomeRes



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
      //  setupCategoryRecyclerView()





        setupRecylerView()

    }

    private fun setupCategoryRecyclerView() {
        categoryRes= SaveSharedPreference.getCategoryResValue(requireContext())!!
        topCategoryAdapter = CommonRVAdapter(ScreenName.FRAGMENT_HOME_TOP_CATEGORY.value,this)
        topCategoryAdapter.setItems(categoryRes.data as ArrayList<Category>)
        binding.recyclerView.layoutManager =  LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerView.adapter = topCategoryAdapter
    }

    private fun setupRecylerView()
    {
        val homeJsonString = CommonUtility.getJsonDataFromAsset(requireContext(), "home.json")
        homeRes = GsonHelper.fromJson(homeJsonString, HomeRes::class.java)!!

        homeAdapter = HomeAdapter(this)
        homeAdapter.setItems(homeRes.views as ArrayList<ViewType>)
        binding.recyclerView.layoutManager =  LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = homeAdapter
    }



    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }

    override fun onSelectItemRVType(selectedItem: Any) {
       "Hellol"
    }


}