package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.inactive.Inactive
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.prospectives.Prospective
import com.licapps.bmmis.databinding.FragmentResBuildingBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.ResBuildingListAdapter
import com.licapps.bmmis.ui.viewmodels.InactiveViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InactiveResourcesFragment : Fragment(), ResBuildingListAdapter.ResBuildItemListener {

    private var binding: FragmentResBuildingBinding by autoCleared()
    private val viewModel: InactiveViewModel by viewModels()
    private lateinit var adapter: ResBuildingListAdapter
    private var bocItemList = ArrayList<Inactive>()
    private val apiRequest = CommonReq()

    private var sortDaysAsc = true
    private var sortMonthAsc = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResBuildingBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch = (activity as NewHomeActivity).branch
        setInitialUI()
        setupRecyclerView()
        setupObservers()
        setOnClickFun()
        viewModel.getInactiveResources(apiRequest)
    }


    private fun setInitialUI() {

        binding.numbersMTV.text = "For Day"
        binding.depositsMTV.text = "For Months"
    }

    private fun setupRecyclerView() {
        adapter = ResBuildingListAdapter(ScreenName.INACTIVE_RESOURCE.value,this)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }

    private fun setOnClickFun() {

        binding.numbersMTV.setOnClickListener {

            sortResult(AppConstants.SORT_FOR_DAYS)
        }
        binding.depositsMTV.setOnClickListener {
            sortResult(AppConstants.SORT_FOR_MONTH)
        }

    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null && it.data.status == 1) {
                        if (it.data.data.isNotEmpty()) {
                            bocItemList = it.data.data as ArrayList<Inactive>
                            addTotalItem()
                            binding.noResultIV.visibility = View.GONE
                            sortResult(AppConstants.SORT_FOR_DAYS)
                            // adapter.setItems(bocItemList)
                        } else {
                            binding.noResultIV.visibility = View.VISIBLE

                        }
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                Resource.Status.ERROR -> {
                    setProgressBar(false)
                    if (it.message?.contains("401") == true) {
                        Toast.makeText(
                            requireContext(),
                            R.string.session_expired,
                            Toast.LENGTH_SHORT
                        ).show()
                        activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->
                    setProgressBar(true)
            }
        })

    }

    private fun addTotalItem() {

        var resBuildingItem: Inactive
        if (bocItemList != null && bocItemList.size > 0) {
            resBuildingItem = Inactive()
            var totalByMonth = 0
            var totalforDay = 0
            for (item in bocItemList) {
                totalforDay = totalforDay + item.forDay.toInt()
                totalByMonth = totalByMonth + item.forMonth.toInt()
            }

            DebugHandler.log("Total :: " + totalforDay + " ::" + totalByMonth)

            resBuildingItem.forMonth = totalByMonth.toString()
            resBuildingItem.forDay = totalforDay.toString()
            resBuildingItem.type = AppConstants.TOTAL
            bocItemList.add(resBuildingItem)
        }

    }

    private fun sortResult(sortFilter: String) {
        if(!bocItemList.isNullOrEmpty()) {
            var totalItem: Inactive = bocItemList.get(bocItemList.size - 1)
            var activisationListSorted = ArrayList<Inactive>()
            activisationListSorted.addAll(bocItemList)
            activisationListSorted.remove(totalItem)

            binding.numbersMTV.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            binding.depositsMTV.setBackgroundColor(resources.getColor(R.color.colorPrimary))


            when (sortFilter) {
                AppConstants.SORT_FOR_DAYS -> {
                    if (sortDaysAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forDay.toInt() > rhs.forDay.toInt()) -1 else if (lhs.forDay.toInt() < rhs.forDay.toInt()) 1 else 0
                        })

                        binding.numbersMTV.setBackgroundColor(resources.getColor(R.color.colorSortAsc))

                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forDay.toInt() < rhs.forDay.toInt()) -1 else if (lhs.forDay.toInt() > rhs.forDay.toInt()) 1 else 0
                        })
                        binding.numbersMTV.setBackgroundColor(resources.getColor(R.color.colorSortDesc))
                    }

                    sortDaysAsc = !sortDaysAsc
                }

                AppConstants.SORT_FOR_MONTH -> {
                    if (sortMonthAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forMonth.toDouble() > rhs.forMonth.toDouble()) -1 else if (lhs.forMonth.toDouble() < rhs.forMonth.toDouble()) 1 else 0
                        })

                        binding.depositsMTV.setBackgroundColor(resources.getColor(R.color.colorSortAsc))
                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forMonth.toDouble() < rhs.forMonth.toDouble()) -1 else if (lhs.forMonth.toDouble() > rhs.forMonth.toDouble()) 1 else 0
                        })
                        binding.depositsMTV.setBackgroundColor(resources.getColor(R.color.colorSortDesc))
                    }
                    sortMonthAsc = !sortMonthAsc
                }


            }
            activisationListSorted.add(totalItem)
            adapter.setItems(activisationListSorted)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_sort).isVisible = true
        val sortNOPMenu = menu.findItem(R.id.action_sort_nop)
        val sortFPMenu = menu.findItem(R.id.action_sort_fp)
        sortNOPMenu.isVisible = true

        sortFPMenu.isVisible = true
        sortNOPMenu.title = "Sorting on Months"
        sortFPMenu.title = "Sorting on  Days"


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_FOR_MONTH)
                true
            }
            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_FOR_DAYS)
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun setProgressBar(b: Boolean) {
        if (!b) {
            binding.progressBarShim.shimmerLayout.visibility = View.GONE
            binding.progressBar.progressBar.visibility = View.GONE
            binding.progressBarShim.shimmerLayout.showShimmer(false)
        } else {
            binding.progressBarShim.shimmerLayout.visibility = View.VISIBLE
            binding.progressBar.progressBar.visibility = View.VISIBLE
            binding.progressBarShim.shimmerLayout.showShimmer(true)
        }
    }

    override fun onClickedCard(cardName: Any) {

    }


    override fun onClickedCard(item: Any, requestType: Any) {
        item as Inactive
        var screenToShow=""
        var inactiveRequestType=""
        if (item.type == "DevOff") {
            screenToShow=ScreenName.INACTIVE_LIST_DO.value
            if(requestType.equals(AppConstants.FOR_MONTH))
            {
                inactiveRequestType=AppConstants.REQ_INACT_DO_FOR_MONTH
            }else{
                inactiveRequestType=AppConstants.REQ_INACT_DO_FOR_DAY
            }
            findNavController().navigate(
                    R.id.action_inactiveFragment_to_inactiveResListFragment,
                    bundleOf(IntentConstants.CASES_REQ_SCREEN to screenToShow,IntentConstants.REQ_INACTIVE_TYPE_SCREEN to inactiveRequestType)
            )
        } else if (item.type == "CLIA") {
            screenToShow=ScreenName.INACTIVE_LIST_CLIA.value
            if(requestType.equals(AppConstants.FOR_MONTH))
            {
                inactiveRequestType=AppConstants.REQ_INACT_CLIA_FOR_MONTH
            }else{
                inactiveRequestType=AppConstants.REQ_INACT_CLIA_FOR_DAY
            }
            findNavController().navigate(
                    R.id.action_inactiveFragment_to_inactiveResListFragment,
                    bundleOf(IntentConstants.CASES_REQ_SCREEN to screenToShow,IntentConstants.REQ_INACTIVE_TYPE_SCREEN to inactiveRequestType)
            )
        }

    }

}