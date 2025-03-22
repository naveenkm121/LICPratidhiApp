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
import com.licapps.bmmis.data.model.boc.BOCItem
import com.licapps.bmmis.data.model.nbforday.NBForDayItem
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.resbuilding.ResBuildingItem
import com.licapps.bmmis.databinding.FragmentBocBinding
import com.licapps.bmmis.databinding.FragmentNbForDayBinding
import com.licapps.bmmis.databinding.FragmentResBuildingBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.BOCListAdapter
import com.licapps.bmmis.ui.adapters.NBForDayListAdapter
import com.licapps.bmmis.ui.adapters.ResBuildingListAdapter
import com.licapps.bmmis.ui.viewmodels.BOCViewModel
import com.licapps.bmmis.ui.viewmodels.NBForDayViewModel
import com.licapps.bmmis.ui.viewmodels.ResBuildingViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NBForDayFragment : Fragment() {

    private var binding: FragmentNbForDayBinding by autoCleared()
    private val viewModel: NBForDayViewModel by viewModels()
    private lateinit var adapter: NBForDayListAdapter
    private var bocItemList = ArrayList<NBForDayItem>()
    private val apiRequest = CommonReq()

    private var sortFPAsc=true
    private var sortNOPAsc=true;
    private var sortAgentsAsc=true;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNbForDayBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
        viewModel.getNBForDay(apiRequest);
        setupRecyclerView()
        setupObservers()
        setOnClickFun()

    }





    private fun setupRecyclerView() {
        adapter = NBForDayListAdapter(ScreenName.NB_FOR_DAY.value)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {

                            bocItemList= it.data.data as ArrayList<NBForDayItem>

                            binding.noResultIV.visibility = View.GONE
                           // adapter.setItems(bocItemList)
                            sortResult(AppConstants.SORT_NOP)
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

    private fun setOnClickFun(){

        binding.nopMTV.setOnClickListener {

            sortResult(AppConstants.SORT_NOP)
        }
        binding.fpMTV.setOnClickListener {
            sortResult(AppConstants.SORT_FP)
        }

        binding.activisationMTV.setOnClickListener {
            sortResult(AppConstants.SORT_AGENTS)
        }


    }

    private fun sortResult(sortFilter:String )
    {
        if(!bocItemList.isNullOrEmpty()) {

            binding.nopMTV.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            binding.fpMTV.setBackgroundColor(resources.getColor(R.color.colorPrimary))
            binding.activisationMTV.setBackgroundColor(resources.getColor(R.color.colorPrimary))


            when (sortFilter) {
                AppConstants.SORT_NOP -> {
                    if (sortNOPAsc) {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nop.toInt() > rhs.nop.toInt()) -1 else if (lhs.nop.toInt() < rhs.nop.toInt()) 1 else 0
                        })
                        binding.nopMTV.setBackgroundColor(resources.getColor(R.color.colorSortAsc))

                    } else {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nop.toInt() < rhs.nop.toInt()) -1 else if (lhs.nop.toInt() > rhs.nop.toInt()) 1 else 0
                        })
                        binding.nopMTV.setBackgroundColor(resources.getColor(R.color.colorSortDesc))
                    }

                    sortNOPAsc = !sortNOPAsc
                }

                AppConstants.SORT_FP -> {
                    if (sortFPAsc) {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.amount.toDouble() > rhs.amount.toDouble()) -1 else if (lhs.amount.toDouble() < rhs.amount.toDouble()) 1 else 0
                        })

                        binding.fpMTV.setBackgroundColor(resources.getColor(R.color.colorSortAsc))
                    } else {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.amount.toDouble() < rhs.amount.toDouble()) -1 else if (lhs.amount.toDouble() > rhs.amount.toDouble()) 1 else 0
                        })
                        binding.fpMTV.setBackgroundColor(resources.getColor(R.color.colorSortDesc))
                    }
                    sortFPAsc = !sortFPAsc
                }

                AppConstants.SORT_AGENTS -> {
                    if (sortAgentsAsc) {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.active.toInt() > rhs.active.toInt()) -1 else if (lhs.active.toInt() < rhs.active.toInt()) 1 else 0
                        })
                        binding.activisationMTV.setBackgroundColor(resources.getColor(R.color.colorSortAsc))

                    } else {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.active.toInt() < rhs.active.toInt()) -1 else if (lhs.active.toInt() > rhs.active.toInt()) 1 else 0
                        })
                        binding.activisationMTV.setBackgroundColor(resources.getColor(R.color.colorSortDesc))
                    }
                    sortAgentsAsc = !sortAgentsAsc
                }


            }

            adapter.setItems(bocItemList)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_sort).isVisible=true
        menu.findItem(R.id.action_sort_nop).isVisible=true
        menu.findItem(R.id.action_sort_agents).isVisible=true

        val  sortFBMenu=menu.findItem(R.id.action_sort_fp)
        sortFBMenu.isVisible=true
        sortFBMenu.title="Sort by FPI"

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_NOP);
                true
            }
            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_FP);
                true
            }

            R.id.action_sort_agents -> {
                sortResult(AppConstants.SORT_AGENTS);
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

}