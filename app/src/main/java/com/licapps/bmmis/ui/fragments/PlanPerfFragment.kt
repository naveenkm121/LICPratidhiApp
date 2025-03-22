package com.licapps.bmmis.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.planperf.PlanPerfItem
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.prospectives.Prospective
import com.licapps.bmmis.databinding.FragmentMabDetailsBinding
import com.licapps.bmmis.databinding.FragmentPlanPerfBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.CasesListAdapter
import com.licapps.bmmis.ui.adapters.PlanPerfListAdapter
import com.licapps.bmmis.ui.viewmodels.PlanPerfViewModel
import com.licapps.bmmis.utils.*
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PlanPerfFragment : Fragment() ,PlanPerfListAdapter.CasesListItemListener{

    private var binding: FragmentPlanPerfBinding by autoCleared()
    private val viewModel: PlanPerfViewModel by viewModels()
    private lateinit var adapter: PlanPerfListAdapter
    private lateinit var screenToShow: String
    private var planPerfList = ArrayList<PlanPerfItem>()
    private val apiRequest = CommonReq()

    private var sortPlanAsc=true
    private var sortTFPAsc=true
    private var sortNOPAsc=true;
    private var sortSPAsc=true
    private var sortNSPAsc=true;
    private var sortAgentsAsc=true;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlanPerfBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        apiRequest.branch = (activity as NewHomeActivity).branch
        screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        setupRecyclerView()
        setupObservers()
        setOnClickFun()
        viewModel.getPlanPerfData(apiRequest)
        Timber.d("ScreenToshow:"+screenToShow)

    }


    private fun setupRecyclerView() {
        adapter = PlanPerfListAdapter(this,"")
        binding.casesRV .layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }

    private fun setOnClickFun(){


        binding.planIdMTV.setOnClickListener {
            sortResult(AppConstants.SORT_PLAN)
        }

        binding.tfpHeadingMTV.setOnClickListener {
            sortResult(AppConstants.SORT_TFP)
        }

        binding.nopHeadingMTV.setOnClickListener {

            sortResult(AppConstants.SORT_NOP)
        }
        binding.spHeadingTV.setOnClickListener {
            sortResult(AppConstants.SORT_SP)
        }

        binding.nspHeadingMTV.setOnClickListener {
            sortResult(AppConstants.SORT_NSP)
        }

        binding.agentHeadingMTV.setOnClickListener {
            sortResult(AppConstants.SORT_AGENTS)
        }
    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null) {
                        if (it.data.data.isNotEmpty()) {
                            // binding.progressBar.visibility = View.GONE
                            planPerfList = it.data.data as ArrayList<PlanPerfItem>
                            adapter.setItems(planPerfList)
                        } else {
                            binding.noResultIV.visibility = View.VISIBLE

                        }
                    } else
                        Toast.makeText(
                            requireContext(),
                            R.string.err_in_response,
                            Toast.LENGTH_SHORT
                        ).show()

                }
                Resource.Status.ERROR ->
                {
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

    override fun onClickedListItem(case: PlanPerfItem) {
    }

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val sortMenu = menu.findItem(R.id.action_sort)
       val sortFpMenu= menu.findItem(R.id.action_sort_fp)
        menu.findItem(R.id.action_sort_nop).isVisible=true
        val sortTFPMenu= menu.findItem(R.id.action_sort_fyrp)
        menu.findItem(R.id.action_sort_sp).isVisible=true
        menu.findItem(R.id.action_sort_nsp).isVisible=true
        menu.findItem(R.id.action_sort_agents).isVisible=true
        sortMenu.isVisible = true
        sortFpMenu.isVisible= true;
        sortTFPMenu.isVisible=true;
        sortFpMenu.title="Sort by Plans"
        sortTFPMenu.title="Sort by TFP"

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_PLAN);
                true
            }

            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_NOP);
                true
            }

            R.id.action_sort_fyrp -> {
                sortResult(AppConstants.SORT_TFP);
                true
            }
            R.id.action_sort_sp -> {
                sortResult(AppConstants.SORT_SP);
                true
            }
            R.id.action_sort_nsp -> {
                sortResult(AppConstants.SORT_NSP);
                true
            }
            R.id.action_sort_agents -> {
                sortResult(AppConstants.SORT_AGENTS);
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sortResult(sortFilter:String )
    {
        if(!planPerfList.isNullOrEmpty()) {
            binding.planIdMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.nopHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.nspHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.spHeadingTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.tfpHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.agentHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            when (sortFilter) {

                AppConstants.SORT_PLAN -> {
                    if (sortPlanAsc) {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.plan.toInt() > rhs.plan.toInt()) -1 else if (lhs.plan.toInt() < rhs.plan.toInt()) 1 else 0
                        })
                        binding.planIdMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.plan.toInt() < rhs.plan.toInt()) -1 else if (lhs.plan.toInt() > rhs.plan.toInt()) 1 else 0
                        })
                        binding.planIdMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortPlanAsc = !sortPlanAsc
                }

                AppConstants.SORT_TFP -> {
                    if (sortTFPAsc) {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.tfp.toDouble() > rhs.tfp.toDouble()) -1 else if (lhs.tfp.toDouble() < rhs.tfp.toDouble()) 1 else 0
                        })
                        binding.tfpHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.tfp.toDouble() < rhs.tfp.toDouble()) -1 else if (lhs.tfp.toDouble() > rhs.tfp.toDouble()) 1 else 0
                        })
                        binding.tfpHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortTFPAsc = !sortTFPAsc
                }
                AppConstants.SORT_NOP -> {
                    if (sortNOPAsc) {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.nop.toInt() > rhs.nop.toInt()) -1 else if (lhs.nop.toInt() < rhs.nop.toInt()) 1 else 0
                        })

                        binding.nopHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.nop.toInt() < rhs.nop.toInt()) -1 else if (lhs.nop.toInt() > rhs.nop.toInt()) 1 else 0
                        })
                        binding.nopHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortNOPAsc = !sortNOPAsc
                }

                AppConstants.SORT_SP -> {
                    if (sortSPAsc) {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.sp.toDouble() > rhs.sp.toDouble()) -1 else if (lhs.sp.toDouble() < rhs.sp.toDouble()) 1 else 0
                        })
                        binding.spHeadingTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.sp.toDouble() < rhs.sp.toDouble()) -1 else if (lhs.sp.toDouble() > rhs.sp.toDouble()) 1 else 0
                        })
                        binding.spHeadingTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortSPAsc = !sortSPAsc
                }

                AppConstants.SORT_NSP -> {
                    if (sortNSPAsc) {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nsp.toDouble() > rhs.nsp.toDouble()) -1 else if (lhs.nsp.toDouble() < rhs.nsp.toDouble()) 1 else 0
                        })
                        binding.nspHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nsp.toDouble() < rhs.nsp.toDouble()) -1 else if (lhs.nsp.toDouble() > rhs.nsp.toDouble()) 1 else 0
                        })
                        binding.nspHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortNSPAsc = !sortNSPAsc
                }

                AppConstants.SORT_AGENTS -> {
                    if (sortAgentsAsc) {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.actag.toInt() > rhs.actag.toInt()) -1 else if (lhs.actag.toInt() < rhs.actag.toInt()) 1 else 0
                        })
                        binding.agentHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        planPerfList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.actag.toInt() < rhs.actag.toInt()) -1 else if (lhs.actag.toInt() > rhs.actag.toInt()) 1 else 0
                        })
                        binding.agentHeadingMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                        //  binding.agentHeadingMTV.setBackgroundColor(R.color.red);
                    }
                    sortAgentsAsc = !sortAgentsAsc
                }


            }

            adapter.setItems(planPerfList)
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
