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
import com.licapps.bmmis.constants.ResourceIdConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.inactive.Inactive
import com.licapps.bmmis.data.model.nbperformance.NBPerformance
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.prospectives.Prospective
import com.licapps.bmmis.data.model.resource.AvailResource
import com.licapps.bmmis.data.model.resource.AvailResourceData
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.FragmentNbuptodayBinding
import com.licapps.bmmis.databinding.FragmentResourceBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.CasesListAdapter
import com.licapps.bmmis.ui.adapters.ResBuildingListAdapter
import com.licapps.bmmis.ui.viewmodels.AvailResourceViewModel
import com.licapps.bmmis.ui.viewmodels.NBUptoDayViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ResourceFragment : Fragment() ,ResBuildingListAdapter.ResBuildItemListener{

    private var binding: FragmentResourceBinding by autoCleared()
    private val viewModel: AvailResourceViewModel by viewModels()
    private val apiRequest = CommonReq()
    private lateinit var adapter: ResBuildingListAdapter
    private var availResourceList = ArrayList<AvailResource>()

    private var sortNumberAsc = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResourceBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
         viewModel.getAvailableResource(apiRequest);
        setOnClickFun()
        setupObservers()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        adapter = ResBuildingListAdapter(ScreenName.AVAILABLE_RESOURCE.value,this)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }

    private fun setOnClickFun() {


        binding.depositsMTV.setOnClickListener {
            sortResult(AppConstants.SORT_NUMBER)
        }

    }



    private fun setupObservers() {

        viewModel.response.observe(viewLifecycleOwner, Observer {

            when(it.status)
            {
                Resource.Status.SUCCESS->{
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {
                            // binding.progressBar.visibility = View.GONE
                            // topPerformersList.clear()
                            availResourceList = it.data.data as ArrayList<AvailResource>
                            addTotalItem()
                            binding.noResultIV.visibility = View.GONE
                            adapter.setItems(availResourceList)
                           // setResourceDataUI();

                        } else {
                            binding.noResultIV.visibility = View.VISIBLE

                        }
                    }

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
                Resource.Status.LOADING ->{
                    setProgressBar(true)
                }

            }
        })


    }


    private fun addTotalItem() {

        var resBuildingItem: AvailResource
        if (availResourceList != null && availResourceList.size > 0) {
            resBuildingItem = AvailResource()
            var total = 0
            for (item in availResourceList) {
                total = total + item.count.toInt()
            }
            resBuildingItem.count = total.toString()
            resBuildingItem.type = AppConstants.TOTAL
            availResourceList.add(resBuildingItem)
        }

    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_sort).isVisible = true
        val sortFPMenu = menu.findItem(R.id.action_sort_fp)

        sortFPMenu.isVisible = true
        sortFPMenu.title = "Sorting by numbers"


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_NUMBER)
                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun sortResult(sortFilter: String) {
        if(!availResourceList.isNullOrEmpty()) {
            var totalItem: AvailResource = availResourceList.get(availResourceList.size - 1)
            var activisationListSorted = ArrayList<AvailResource>()
            activisationListSorted.addAll(availResourceList)
            activisationListSorted.remove(totalItem)

            binding.depositsMTV.setBackgroundColor(resources.getColor(R.color.colorPrimary))


            when (sortFilter) {
                AppConstants.SORT_NUMBER -> {
                    if (sortNumberAsc) {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.count.toInt() > rhs.count.toInt()) -1 else if (lhs.count.toInt() < rhs.count.toInt()) 1 else 0
                        })

                        binding.depositsMTV.setBackgroundColor(resources.getColor(R.color.colorSortAsc))

                    } else {
                        activisationListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.count.toInt() < rhs.count.toInt()) -1 else if (lhs.count.toInt() > rhs.count.toInt()) 1 else 0
                        })
                        binding.depositsMTV.setBackgroundColor(resources.getColor(R.color.colorSortDesc))
                    }

                    sortNumberAsc = !sortNumberAsc
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


    override fun onClickedCard(cardName: Any) {

    }

    override fun onClickedCard(cardName: Any, requestType: Any) {

    }
}