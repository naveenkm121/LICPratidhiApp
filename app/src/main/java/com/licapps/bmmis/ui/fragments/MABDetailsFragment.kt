package com.licapps.bmmis.ui.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.mab.MABItem
import com.licapps.bmmis.data.model.mab.MABReq
import com.licapps.bmmis.databinding.FragmentMabDetailsBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.MABListAdapter
import com.licapps.bmmis.ui.viewmodels.MABViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MABDetailsFragment : Fragment() {

    private var binding: FragmentMabDetailsBinding by autoCleared()
    private val viewModel: MABViewModel by viewModels()
    private lateinit var adapter: MABListAdapter
    private var bocItemList = ArrayList<MABItem>()
    private val apiRequest = MABReq()
    private var month = ""

    private var sortFPAsc=true;
    private var sortFYRPAsc=true
    private var sortNOPAsc=true;


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
          month = arguments?.getString(IntentConstants.MAB_MONTH).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
        apiRequest.month=month
        viewModel.getMABData(apiRequest);
        setupRecyclerView()
        setupObservers()

    }



    private fun setupRecyclerView() {
        adapter = MABListAdapter(ScreenName.MAB.value)
        binding.mabRV.layoutManager = LinearLayoutManager(requireContext())
        binding.mabRV.adapter = adapter
    }

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val sortMenu = menu.findItem(R.id.action_sort)
        val sortFYRPMenu = menu.findItem(R.id.action_sort_fyrp)
        sortMenu.isVisible = true
        sortFYRPMenu.isVisible = true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_sort_fp -> {
                // navigate to settings screen
                DebugHandler.log("Hello  Sorting")
                sortResult(AppConstants.SORT_FP);

                true
            }

            R.id.action_sort_nop -> {
                // navigate to settings screen
                DebugHandler.log("Hello  NOP")
                sortResult(AppConstants.SORT_NOP);

                true
            }
            R.id.action_sort_fyrp -> {
                // navigate to settings screen
                DebugHandler.log("Hello  SORT_FYRP")
                sortResult(AppConstants.SORT_FYRP);

                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun sortResult(sortFilter:String )
    {
        if(!bocItemList.isNullOrEmpty()) {
            when (sortFilter) {
                AppConstants.SORT_NOP -> {
                    if (sortNOPAsc) {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.noOfLives.toInt() > rhs.noOfLives.toInt()) -1 else if (lhs.noOfLives.toInt() < rhs.noOfLives.toInt()) 1 else 0
                        })
                        sortNOPAsc = false
                    } else {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.noOfLives.toInt() < rhs.noOfLives.toInt()) -1 else if (lhs.noOfLives.toInt() > rhs.noOfLives.toInt()) 1 else 0
                        })
                        sortNOPAsc = true
                    }

                }

                AppConstants.SORT_FP -> {

                    if (sortFPAsc) {

                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.fyp.toDouble() > rhs.fyp.toDouble()) -1 else if (lhs.fyp.toDouble() < rhs.fyp.toDouble()) 1 else 0
                        })
                        sortFPAsc = false
                    } else {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.fyp.toDouble() < rhs.fyp.toDouble()) -1 else if (lhs.fyp.toDouble() > rhs.fyp.toDouble()) 1 else 0
                        })
                        sortFPAsc = true
                    }

                }

                AppConstants.SORT_FYRP -> {

                    if (sortFYRPAsc) {

                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.fyrp.toDouble() > rhs.fyrp.toDouble()) -1 else if (lhs.fyrp.toDouble() < rhs.fyrp.toDouble()) 1 else 0
                        })
                        sortFYRPAsc = false
                    } else {
                        bocItemList.sortWith(Comparator { lhs, rhs ->
                            // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                            if (lhs.fyrp.toDouble() < rhs.fyrp.toDouble()) -1 else if (lhs.fyrp.toDouble() > rhs.fyrp.toDouble()) 1 else 0
                        })
                        sortFYRPAsc = true
                    }

                }

            }


            adapter.setItems(bocItemList)
        }
    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {
                            bocItemList= it.data.data as ArrayList<MABItem>
                            bocItemList.forEachIndexed {index, it1->
                                run {
                                    it1.srno =index+1
                                }
                            }
                            binding.noResultIV.visibility = View.GONE
                            sortResult(AppConstants.SORT_FP)
                           // adapter.setItems(bocItemList)
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