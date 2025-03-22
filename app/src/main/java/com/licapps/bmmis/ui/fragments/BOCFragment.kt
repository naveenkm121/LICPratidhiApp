package com.licapps.bmmis.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.data.model.boc.BOCItem
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.databinding.FragmentBocBinding
import com.licapps.bmmis.ui.activities.LaunchActivity
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.BOCListAdapter
import com.licapps.bmmis.ui.viewmodels.BOCViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BOCFragment : Fragment() {

    private var binding: FragmentBocBinding by autoCleared()
    private val viewModel: BOCViewModel by viewModels()
    private lateinit var adapter: BOCListAdapter
    private var bocItemList = ArrayList<BOCItem>()
    private val apiRequest = CommonReq()

    private var sortNumberAsc=true;
    private var sortDepositsAsc=true;


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBocBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
        viewModel.getBOCdata(apiRequest);
        setupRecyclerView()
        setupObservers()
        setOnClickFun()

    }





    private fun setupRecyclerView() {
        adapter = BOCListAdapter()
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null && it.data.status == 1) {
                        if (it.data.data.isNotEmpty()) {

                            bocItemList = it.data.data as ArrayList<BOCItem>
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
                    if (it.message?.contains("401") == true) {
                        Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };

                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                Resource.Status.LOADING ->
                    setProgressBar(true)
            }
        })

    }


    private fun  addTotalItem(){

        var bocItem: BOCItem
        if(bocItemList!=null && bocItemList.size>0)
        {
            bocItem= BOCItem()
            var totalCount=0
            var totalAmt:Int=0
            for (item in bocItemList) {
                totalCount=totalCount+item.count.toInt();
                totalAmt=totalAmt+item.amount.toInt();
            }

            bocItem.count=totalCount.toString()
            bocItem.amount=totalAmt.toString()
            bocItem.type= AppConstants.TOTAL
            bocItemList.add(bocItem)
        }

    }

    private fun setOnClickFun(){

        binding.numbersMTV.setOnClickListener {
            sortResult(AppConstants.SORT_NUMBER)
        }

        binding.depositsMTV.setOnClickListener {
            sortResult(AppConstants.SORT_DEPOSITS)
        }


    }


    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val sortMenu = menu.findItem(R.id.action_sort)
        val sortFpMenu= menu.findItem(R.id.action_sort_fp)
        val sortNOPMenu= menu.findItem(R.id.action_sort_nop)
        sortMenu.isVisible = true
        sortFpMenu.isVisible= true;
        sortNOPMenu.isVisible=true;
        sortFpMenu.title="Sort by Numbers"
        sortNOPMenu.title="Sort by Deposits"

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_NUMBER);
                true
            }

            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_DEPOSITS);
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sortResult(sortFilter: String)
    {
        if(!bocItemList.isNullOrEmpty()) {
            var totalItem: BOCItem = bocItemList.get(bocItemList.size - 1);
            var activisationListSorted = ArrayList<BOCItem>()
            activisationListSorted.addAll(bocItemList)
            activisationListSorted.remove(totalItem);

            binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


            when (sortFilter) {

                AppConstants.SORT_NUMBER -> {
                    if (sortNumberAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.count.toInt() > rhs.count.toInt()) -1 else if (lhs.count.toInt() < rhs.count.toInt()) 1 else 0
                        })
                        binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.count.toInt() < rhs.count.toInt()) -1 else if (lhs.count.toInt() > rhs.count.toInt()) 1 else 0
                        })
                        binding.numbersMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortNumberAsc = !sortNumberAsc
                }

                AppConstants.SORT_DEPOSITS -> {
                    if (sortDepositsAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.amount.toDouble() > rhs.amount.toDouble()) -1 else if (lhs.amount.toDouble() < rhs.amount.toDouble()) 1 else 0
                        })
                        binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.amount.toDouble() < rhs.amount.toDouble()) -1 else if (lhs.amount.toDouble() > rhs.amount.toDouble()) 1 else 0
                        })
                        binding.depositsMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortDepositsAsc = !sortDepositsAsc
                }
            }

            activisationListSorted.add(totalItem)
            adapter.setItems(activisationListSorted)
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

}