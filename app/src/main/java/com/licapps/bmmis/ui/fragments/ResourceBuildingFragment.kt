package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.activisation.ActivisationItem
import com.licapps.bmmis.data.model.boc.BOCItem
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.resbuilding.ResBuildingItem
import com.licapps.bmmis.databinding.FragmentBocBinding
import com.licapps.bmmis.databinding.FragmentResBuildingBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.BOCListAdapter
import com.licapps.bmmis.ui.adapters.ResBuildingListAdapter
import com.licapps.bmmis.ui.viewmodels.BOCViewModel
import com.licapps.bmmis.ui.viewmodels.ResBuildingViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResourceBuildingFragment : Fragment(),ResBuildingListAdapter.ResBuildItemListener {

    private var binding: FragmentResBuildingBinding by autoCleared()
    private val viewModel: ResBuildingViewModel by viewModels()
    private lateinit var adapter: ResBuildingListAdapter
    private var bocItemList = ArrayList<ResBuildingItem>()
    private val apiRequest = CommonReq()

    private var sortDaysAsc=true
    private var sortMonthAsc=true;


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
        apiRequest.branch=(activity as NewHomeActivity).branch
        setupRecyclerView()
        setupObservers()
        setOnClickFun()
        viewModel.getResBuildingData(apiRequest);
    }




    private fun setupRecyclerView() {
        adapter = ResBuildingListAdapter(ScreenName.RESOURCE_BUILDING.value,this)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }


    private fun setOnClickFun(){

        binding.numbersMTV.setOnClickListener {

            sortResult(AppConstants.SORT_FOR_MONTH)
        }
        binding.depositsMTV.setOnClickListener {
            sortResult(AppConstants.SORT_FOR_YEARS)
        }

    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {

                            bocItemList= it.data.data as ArrayList<ResBuildingItem>
                            addTotalItem()
                            binding.noResultIV.visibility = View.GONE
                            adapter.setItems(bocItemList)
                        } else {
                            binding.noResultIV.visibility = View.VISIBLE

                        }
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                Resource.Status.ERROR -> {
                    setProgressBar(false)
                    if(it.message?.contains("401")==true){
                        Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };
                    }
                    else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->
                    setProgressBar(true)
            }
        })

    }

    private fun  addTotalItem(){

        var resItem: ResBuildingItem
        if(bocItemList!=null && bocItemList.size>0)
        {
            resItem= ResBuildingItem()
            var totalforMonth=0
            var totalforYear:Int=0
            for (item in bocItemList) {
                if(item.type.equals("Termination"))
                {
                    totalforMonth=totalforMonth-item.forMonth.toInt();
                    totalforYear=totalforYear-item.forYear.toInt();
                    DebugHandler.log("Termination value "+totalforMonth +":: "+totalforYear)
                }else{
                    totalforMonth=totalforMonth+item.forMonth.toInt();
                    totalforYear=totalforYear+item.forYear.toInt();
                }


            }

            resItem.forMonth=totalforMonth.toString()
            resItem.forYear=totalforYear.toString()
            resItem.type= AppConstants.TOTAL
            bocItemList.add(resItem)
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
    private fun sortResult(sortFilter:String )
    {
        if(!bocItemList.isNullOrEmpty()) {
            var totalItem: ResBuildingItem = bocItemList.get(bocItemList.size - 1);
            var activisationListSorted = ArrayList<ResBuildingItem>()
            activisationListSorted.addAll(bocItemList)
            activisationListSorted.remove(totalItem);

            binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


            when (sortFilter) {
                AppConstants.SORT_FOR_YEARS -> {
                    if (sortDaysAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forYear.toInt() > rhs.forYear.toInt()) -1 else if (lhs.forYear.toInt() < rhs.forYear.toInt()) 1 else 0
                        })

                        binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forYear.toInt() < rhs.forYear.toInt()) -1 else if (lhs.forYear.toInt() > rhs.forYear.toInt()) 1 else 0
                        })
                        binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortDaysAsc = !sortDaysAsc
                }

                AppConstants.SORT_FOR_MONTH -> {
                    if (sortMonthAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forMonth.toDouble() > rhs.forMonth.toDouble()) -1 else if (lhs.forMonth.toDouble() < rhs.forMonth.toDouble()) 1 else 0
                        })

                        binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forMonth.toDouble() < rhs.forMonth.toDouble()) -1 else if (lhs.forMonth.toDouble() > rhs.forMonth.toDouble()) 1 else 0
                        })
                        binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortMonthAsc = !sortMonthAsc
                }


            }
            activisationListSorted.add(totalItem)
            adapter.setItems(activisationListSorted)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_sort).isVisible=true
        val sortNOPMenu=menu.findItem(R.id.action_sort_nop)
        val sortFPMenu= menu.findItem(R.id.action_sort_fp)
        sortNOPMenu.isVisible=true

        sortFPMenu.isVisible=true
        sortFPMenu.title="Sorting on  Months"
        sortNOPMenu.title="Sorting on Years"


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_FOR_MONTH);
                true
            }


            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_FOR_YEARS);
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClickedCard(cardName: Any) {

    }

    override fun onClickedCard(cardName: Any, requestType: Any) {

    }


}