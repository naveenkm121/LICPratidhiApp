package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.activisation.ActivisationItem
import com.licapps.bmmis.data.model.boc.BOCItem
import com.licapps.bmmis.data.model.channelwise.ChannelwiseNB
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.resbuilding.ResBuildingItem
import com.licapps.bmmis.databinding.FragmentBocBinding
import com.licapps.bmmis.databinding.FragmentResBuildingBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.BOCListAdapter
import com.licapps.bmmis.ui.adapters.ResBuildingListAdapter
import com.licapps.bmmis.ui.viewmodels.ActivisationViewModel
import com.licapps.bmmis.ui.viewmodels.BOCViewModel
import com.licapps.bmmis.ui.viewmodels.ResBuildingViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivisationFragment : Fragment(),ResBuildingListAdapter.ResBuildItemListener {

    private var binding: FragmentResBuildingBinding by autoCleared()
    private val viewModel: ActivisationViewModel by viewModels()
    private lateinit var adapter: ResBuildingListAdapter
    private var activisationList = ArrayList<ActivisationItem>()
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
        setInitialUI()
        setupRecyclerView()
        setupObservers()
        apiRequest.branch=(activity as NewHomeActivity).branch
        viewModel.getActivisationData(apiRequest);
        setOnClickFun()
    }

    private fun setInitialUI() {
        binding.channelsMTV.text=getString(R.string.resource)
        binding.numbersMTV.text=getString(R.string.for_day)
        binding.depositsMTV.text=getString(R.string.for_month)
    }


    private fun setupRecyclerView() {
        adapter = ResBuildingListAdapter(ScreenName.ACTIVISATION.value,this)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }

    private fun setOnClickFun(){

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
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {
                            activisationList= it.data.data as ArrayList<ActivisationItem>
                            addTotalItem();
                            binding.noResultIV.visibility = View.GONE
                            sortResult(AppConstants.SORT_FOR_DAYS)
                           // adapter.setItems(activisationList)
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

       var activisationItem:ActivisationItem
       if(activisationList!=null && activisationList.size>0)
       {
           activisationItem= ActivisationItem()
           var totalByMonth=0
           var totalforDay=0
           for (item in activisationList) {
               totalforDay=totalforDay+item.forDay.toInt();
               totalByMonth=totalByMonth+item.forMonth.toInt();
           }

           activisationItem.forMonth=totalByMonth.toString()
           activisationItem.forDay=totalforDay.toString()
           activisationItem.type=AppConstants.TOTAL
           activisationList.add(activisationItem)
       }

    }

    private fun sortResult(sortFilter:String )
    {
        if(!activisationList.isNullOrEmpty()) {
            var totalItem: ActivisationItem = activisationList.get(activisationList.size - 1);
            var activisationListSorted = ArrayList<ActivisationItem>()
            activisationListSorted.addAll(activisationList)
            activisationListSorted.remove(totalItem);

            binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


            when (sortFilter) {
                AppConstants.SORT_FOR_DAYS -> {
                    if (sortDaysAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forDay.toInt() > rhs.forDay.toInt()) -1 else if (lhs.forDay.toInt() < rhs.forDay.toInt()) 1 else 0
                        })

                        binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forDay.toInt() < rhs.forDay.toInt()) -1 else if (lhs.forDay.toInt() > rhs.forDay.toInt()) 1 else 0
                        })
                        binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortDaysAsc = !sortDaysAsc
                }

                AppConstants.SORT_FOR_MONTH -> {
                    if (sortMonthAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forMonth.toDouble() > rhs.forMonth.toDouble()) -1 else if (lhs.forMonth.toDouble() < rhs.forMonth.toDouble()) 1 else 0
                        })

                        binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.forMonth.toDouble() < rhs.forMonth.toDouble()) -1 else if (lhs.forMonth.toDouble() > rhs.forMonth.toDouble()) 1 else 0
                        })
                        binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
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
        sortFPMenu.title="Sorting on  Days"
        sortNOPMenu.title="Sorting on Months"



    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_FOR_MONTH);
                true
            }
            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_FOR_DAYS);
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

    override fun onClickedCard(cardName: Any, requestType: Any) {

    }

}