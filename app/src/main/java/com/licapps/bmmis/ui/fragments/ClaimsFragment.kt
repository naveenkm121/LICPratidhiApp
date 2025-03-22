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
import com.licapps.bmmis.data.model.claims.ClaimsItem
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
import com.licapps.bmmis.ui.viewmodels.ClaimsViewModel
import com.licapps.bmmis.ui.viewmodels.NBForDayViewModel
import com.licapps.bmmis.ui.viewmodels.ResBuildingViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClaimsFragment : Fragment() {

    private var binding: FragmentNbForDayBinding by autoCleared()
    private val viewModel: ClaimsViewModel by viewModels()
    private lateinit var adapter: NBForDayListAdapter
    private var claimsList = ArrayList<ClaimsItem>()
    private val apiRequest = CommonReq()
    private var sortBookedAsc=true
    private var sortClaimedAsc=true
    private var sortSettledAsc=true;

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
        setupRecyclerView()
        setupObservers()
        setInitialUI()
        setOnClickHandle()
        viewModel.getClaimsData(apiRequest);
    }

    private fun setInitialUI() {
        binding.nopMTV.text=getString(R.string.booked)
        binding.fpMTV.text=getString(R.string.settled)
        binding.activisationMTV.text=getString(R.string.outstanding)

    }


    private fun setupRecyclerView() {
        adapter = NBForDayListAdapter(ScreenName.CLAIMS.value)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }


    private fun setOnClickHandle(){


        binding.nopMTV.setOnClickListener {
            sortResult(AppConstants.SORT_BOOKED)
        }

        binding.fpMTV.setOnClickListener {
            sortResult(AppConstants.SORT_SETTLED)
        }

        binding.activisationMTV.setOnClickListener {

            sortResult(AppConstants.SORT_OUTSTADING)
        }

    }

    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {

                            claimsList= it.data.data as ArrayList<ClaimsItem>
                            addTotalItem()
                            binding.noResultIV.visibility = View.GONE
                            adapter.setItems(claimsList)
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

        var claimsItem:ClaimsItem
        if(claimsList!=null && claimsList.size>0)
        {
            claimsItem= ClaimsItem()
            var totalBooked=0
            var totalSettled=0
            var totalOut=0
            for (item in claimsList) {
                totalBooked=totalBooked+item.booked.toInt();
                totalSettled=totalSettled+item.settled.toInt();
                totalOut=totalOut+item.os.toInt();
            }

            claimsItem.booked=totalBooked.toString()
            claimsItem.settled=totalSettled.toString()
            claimsItem.os=totalOut.toString()
            claimsItem.type= AppConstants.TOTAL
            claimsList.add(claimsItem)
        }

    }


    private fun sortResult(sortFilter:String )
    {
        if(!claimsList.isNullOrEmpty()) {
            var totalItem: ClaimsItem = claimsList.get(claimsList.size - 1);
            var claimsListSorted = ArrayList<ClaimsItem>()
            claimsListSorted.addAll(claimsList)
            claimsListSorted.remove(totalItem);
            //  claimsListSorted.removeAt(claimsListSorted.size-1)
            binding.nopMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.fpMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.activisationMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


            when (sortFilter) {

                AppConstants.SORT_BOOKED -> {
                    if (sortBookedAsc) {
                        claimsListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.booked.toInt() > rhs.booked.toInt()) -1 else if (lhs.booked.toInt() < rhs.booked.toInt()) 1 else 0
                        })
                        binding.nopMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        claimsListSorted.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.booked.toInt() < rhs.booked.toInt()) -1 else if (lhs.booked.toInt() > rhs.booked.toInt()) 1 else 0
                        })
                        binding.nopMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortBookedAsc = !sortBookedAsc
                }

                AppConstants.SORT_SETTLED -> {
                    if (sortSettledAsc) {
                        claimsListSorted.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.settled.toInt() > rhs.settled.toInt()) -1 else if (lhs.settled.toInt() < rhs.settled.toInt()) 1 else 0
                        })

                        binding.fpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        claimsListSorted.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.settled.toInt() < rhs.settled.toInt()) -1 else if (lhs.settled.toInt() > rhs.settled.toInt()) 1 else 0
                        })
                        binding.fpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortSettledAsc = !sortSettledAsc
                }
                AppConstants.SORT_OUTSTADING -> {
                    if (sortClaimedAsc) {
                        claimsListSorted.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.os.toInt() > rhs.os.toInt()) -1 else if (lhs.os.toInt() < rhs.os.toInt()) 1 else 0
                        })
                        binding.activisationMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        claimsListSorted.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.os.toInt() < rhs.os.toInt()) -1 else if (lhs.os.toInt() > rhs.os.toInt()) 1 else 0
                        })
                        binding.activisationMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortClaimedAsc = !sortClaimedAsc
                }


            }
            claimsListSorted.add(totalItem)
            adapter.setItems(claimsListSorted)
        }
    }


    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val sortMenu = menu.findItem(R.id.action_sort)
        val sortBookedMenu= menu.findItem(R.id.action_sort_fp)
        val sortSettledMenu= menu.findItem(R.id.action_sort_nop)
        val sortOSMenu= menu.findItem(R.id.action_sort_nsp)
        sortMenu.isVisible = true
        sortBookedMenu.isVisible= true;
        sortSettledMenu.isVisible=true;
        sortOSMenu.isVisible=true;
        sortBookedMenu.title="Sort by Booked Claims"
        sortSettledMenu.title="Sort by Settled Claims"
        sortOSMenu.title="Sort by Outstanding Claims"

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_fp -> {
                sortResult(AppConstants.SORT_BOOKED);
                true
            }

            R.id.action_sort_nop -> {
                sortResult(AppConstants.SORT_SETTLED);
                true
            }

            R.id.action_sort_nsp -> {
                sortResult(AppConstants.SORT_OUTSTADING);
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