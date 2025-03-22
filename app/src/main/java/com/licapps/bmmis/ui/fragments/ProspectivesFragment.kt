package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.prospectives.Prospective
import com.licapps.bmmis.databinding.FragmentMabDetailsBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.CasesListAdapter
import com.licapps.bmmis.ui.viewmodels.CasesViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ProspectivesFragment : Fragment(), CasesListAdapter.CasesListItemListener {

    private var binding: FragmentMabDetailsBinding by autoCleared()
    private val viewModel: CasesViewModel by viewModels()
    private lateinit var adapter: CasesListAdapter
    private lateinit var screenToShow: String
    private var prospectivesList = ArrayList<Prospective>()
    private val apiRequest = CommonReq()

    private var sortFPAsc=true;
    private var sortNOPAsc=true;
    private var sortCommAsc=true;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMabDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        apiRequest.branch = (activity as NewHomeActivity).branch
        screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        setupRecyclerView()
        setupObservers()
        viewModel.getProspectiveAgents(apiRequest, screenToShow)
        Timber.d("ScreenToshow:"+screenToShow)

    }


    private fun setupRecyclerView() {
        adapter = CasesListAdapter(this, screenToShow)
        binding.mabRV.layoutManager = LinearLayoutManager(requireContext())
        binding.mabRV.adapter = adapter
    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null) {
                        if (it.data.data.isNotEmpty()) {
                            // binding.progressBar.visibility = View.GONE
                            prospectivesList = it.data.data as ArrayList<Prospective>
                            prospectivesList.forEachIndexed { index, it1 ->
                                run {
                                    it1.srno = index + 1
                                }
                            }
                            // addTotalItem();
                            when(screenToShow)
                            {
                                ScreenName.PROSPECTIVE_FP.value -> {
                                    sortResult(AppConstants.SORT_FP)
                                }
                                ScreenName.PROSPECTIVE_MDRT_COMM.value -> {
                                    sortResult(AppConstants.SORT_COMMISSION)
                                }
                                ScreenName.PROSPECTIVE_CENTURION.value -> {
                                    sortResult(AppConstants.SORT_NOP)
                                }
                            }
                            //adapter.setItems(prospectivesList)


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
                Resource.Status.ERROR ->{
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

    override fun onClickedListItem(case: Prospective) {
    }

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_sort).isVisible=true
        menu.findItem(R.id.action_sort_fp).isVisible=true;
        menu.findItem(R.id.action_sort_nop).isVisible=true;

        if(screenToShow.equals(ScreenName.PROSPECTIVE_MDRT_COMM.value )) {
            menu.findItem(R.id.action_sort_nsp).title="Sort by Commission"
            menu.findItem(R.id.action_sort_nsp).isVisible=true;
        }
        if(screenToShow.equals(ScreenName.PROSPECTIVE_CENTURION.value )) {
            menu.findItem(R.id.action_sort_fp).isVisible=false;
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_FP);
                true
            }

            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_NOP);
                true
            }

            R.id.action_sort_nsp -> {
                sortResult(AppConstants.SORT_COMMISSION);
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addTotalItem() {

        var resItem: Prospective
        if (prospectivesList != null && prospectivesList.size > 0) {
            resItem = Prospective()
            var totalNOP: Int = 0
            var totalFP: Double = 0.0
            for (item in prospectivesList) {
                totalNOP = totalNOP + item.nop.toInt()
                totalFP = totalFP + item.fp.toDouble()
            }

            resItem.nop = totalNOP.toString()
            resItem.fp = totalFP.toString()
            resItem.agencyName = AppConstants.TOTAL
            prospectivesList.add(resItem)
        }

    }

    private fun sortResult(sortFilter:String )
    {
        if(!prospectivesList.isNullOrEmpty()) {
            DebugHandler.log("Prospective List ::" + prospectivesList)

            when (sortFilter) {
                AppConstants.SORT_NOP -> {
                    if (sortNOPAsc) {
                        prospectivesList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.nop.toInt() > rhs.nop.toInt()) -1 else if (lhs.nop.toInt() < rhs.nop.toInt()) 1 else 0
                        })
                        sortNOPAsc = false
                    } else {
                        prospectivesList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.nop.toInt() < rhs.nop.toInt()) -1 else if (lhs.nop.toInt() > rhs.nop.toInt()) 1 else 0
                        })
                        sortNOPAsc = true
                    }

                }

                AppConstants.SORT_FP -> {

                    if (sortFPAsc) {

                        prospectivesList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.fp.toDouble() > rhs.fp.toDouble()) -1 else if (lhs.fp.toDouble() < rhs.fp.toDouble()) 1 else 0
                        })
                        sortFPAsc = false
                    } else {
                        prospectivesList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.fp.toDouble() < rhs.fp.toDouble()) -1 else if (lhs.fp.toDouble() > rhs.fp.toDouble()) 1 else 0
                        })
                        sortFPAsc = true
                    }

                }

                AppConstants.SORT_COMMISSION -> {

                    if (sortCommAsc) {

                        prospectivesList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.commission.toDouble() > rhs.commission.toDouble()) -1 else if (lhs.commission.toDouble() < rhs.commission.toDouble()) 1 else 0
                        })
                        sortCommAsc = false
                    } else {
                        prospectivesList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.commission.toDouble() < rhs.commission.toDouble()) -1 else if (lhs.commission.toDouble() > rhs.commission.toDouble()) 1 else 0
                        })
                        sortCommAsc = true
                    }

                }

            }

            DebugHandler.log("Prospective List ::" + prospectivesList)
            adapter.setItems(prospectivesList)
        }
    }

    private fun setProgressBar(b: Boolean) {
        if (!b) {
            binding.progressBarShim.shimmerLayout.visibility = View.GONE
            binding.progressBarShim.shimmerLayout.showShimmer(false)
        } else {
            binding.progressBarShim.shimmerLayout.visibility = View.VISIBLE
            binding.progressBarShim.shimmerLayout.showShimmer(true)
        }
    }


}
