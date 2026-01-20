package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.FragmentTopPerformersBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.TopPerformersListAdapter
import com.licapps.bmmis.ui.viewmodels.TopPerformersViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopPerformersFragment :
    Fragment(),
    TopPerformersListAdapter.CasesListItemListener {

    private var binding: FragmentTopPerformersBinding by autoCleared()
    private val viewModel: TopPerformersViewModel by viewModels()
    private lateinit var adapter: TopPerformersListAdapter

    private var topPerformersList = ArrayList<Performer>()
    private val apiRequest = CommonReq()

    private var whichRequest = 0
    private var type = 0
    private var isNOPSelected = true

    // Sorting state
    private var sortAsc = true
    private var currentSort = AppConstants.SORT_NOP

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopPerformersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apiRequest.branch = (activity as NewHomeActivity).branch

        setupRecyclerView()
        setupObservers()
        setupSelectors()
        setupSortClick()

        // Initial load
        whichRequest = 0
        type = whichRequest
        binding.filterToggleGroup.check(R.id.nopBtn)
        viewModel.getTopPerformers(apiRequest, type)
    }

    /* -------------------- Tabs + Toggle -------------------- */

    private fun setupSelectors() {

        // Tabs (DO / CLIA / Agent)
        binding.performersTabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {

                    whichRequest = when (tab?.position) {
                        0 -> 0   // DO
                        1 -> 4   // CLIA
                        else -> 2 // Agent
                    }

                    type = if (isNOPSelected) whichRequest else whichRequest + 1
                    DebugHandler.log("whichRequest == $type")

                    resetSortUI()
                    adapter.clear()
                    viewModel.getTopPerformers(apiRequest, type)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            }
        )

        // NOP / FP toggle
        binding.filterToggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {

                isNOPSelected = checkedId == R.id.nopBtn
                type = if (isNOPSelected) whichRequest else whichRequest + 1
                DebugHandler.log("whichRequest == $type")
                binding.nopfpMTV.text = if (isNOPSelected) "NOP" else "FP"
                resetSortUI()
                adapter.clear()
                viewModel.getTopPerformers(apiRequest, type)
            }
        }
    }

    /* -------------------- Sorting -------------------- */

    private fun setupSortClick() {
        binding.sortHeaderLL.setOnClickListener {
            currentSort =
                if (isNOPSelected) AppConstants.SORT_NOP else AppConstants.SORT_FP

            sortResult(currentSort)
        }
    }

    private fun resetSortUI() {
        sortAsc = true
        binding.sortIV.setImageResource(R.drawable.ic_arrow_down)
        binding.sortIV.setColorFilter(
            resources.getColor(R.color.colorSortDesc)
        )
    }

    private fun sortResult(sortFilter: String) {

        if (topPerformersList.isEmpty()) return

        when (sortFilter) {

            AppConstants.SORT_NOP -> {
                topPerformersList.sortWith { lhs, rhs ->
                    if (sortAsc)
                        rhs.nop.toInt().compareTo(lhs.nop.toInt())
                    else
                        lhs.nop.toInt().compareTo(rhs.nop.toInt())
                }
            }

            AppConstants.SORT_FP -> {
                topPerformersList.sortWith { lhs, rhs ->
                    if (sortAsc)
                        rhs.fp.toDouble().compareTo(lhs.fp.toDouble())
                    else
                        lhs.fp.toDouble().compareTo(rhs.fp.toDouble())
                }
            }
        }

        // Update icon
        if (sortAsc) {
            binding.sortIV.setImageResource(R.drawable.ic_arrow_down)
            binding.sortIV.setColorFilter(
                resources.getColor(R.color.colorSortDesc)
            )
        } else {
            binding.sortIV.setImageResource(R.drawable.ic_arrow_up)
            binding.sortIV.setColorFilter(
                resources.getColor(R.color.colorSortAsc)
            )
        }

        sortAsc = !sortAsc
        adapter.setItems(topPerformersList)
    }

    /* -------------------- RecyclerView -------------------- */

    private fun setupRecyclerView() {
        adapter = TopPerformersListAdapter(this)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }

    /* -------------------- Observer -------------------- */

    private fun setupObservers() {
        viewModel.responseNOP.observe(viewLifecycleOwner, Observer {

            when (it.status) {

                Resource.Status.SUCCESS -> {
                    setProgressBar(false)

                    if (it.data != null && it.data.data.isNotEmpty()) {

                        topPerformersList = it.data.data as ArrayList<Performer>
                        topPerformersList.forEachIndexed { index, performer ->
                            performer.srno = index + 1
                            performer.type = type
                        }

                        binding.noResultIV.visibility = View.GONE
                        adapter.setItems(topPerformersList)

                    } else {
                        binding.noResultIV.visibility = View.VISIBLE
                    }
                }

                Resource.Status.ERROR -> {
                    setProgressBar(false)

                    if (it.message?.contains("401") == true) {
                        Toast.makeText(
                            requireContext(),
                            R.string.session_expired,
                            Toast.LENGTH_SHORT
                        ).show()
                        activity?.let { act ->
                            CommonUtility.logoutAppSession(act)
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            it.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                Resource.Status.LOADING -> setProgressBar(true)
            }
        })
    }

    override fun onClickedListItem(case: Performer) {
        // Handle item click if needed
    }

    private fun setProgressBar(show: Boolean) {
        if (show) {
            binding.progressBarShim.shimmerLayout.visibility = View.VISIBLE
            binding.progressBar.progressBar.visibility = View.VISIBLE
            binding.progressBarShim.shimmerLayout.showShimmer(true)
        } else {
            binding.progressBarShim.shimmerLayout.visibility = View.GONE
            binding.progressBar.progressBar.visibility = View.GONE
            binding.progressBarShim.shimmerLayout.showShimmer(false)
        }
    }
}
