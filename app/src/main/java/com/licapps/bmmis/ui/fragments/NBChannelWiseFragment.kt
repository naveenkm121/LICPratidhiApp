package com.licapps.bmmis.ui.fragments

import android.opengl.Visibility
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
import com.licapps.bmmis.data.model.channelwise.ChannelwiseNB
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
import com.licapps.bmmis.ui.viewmodels.NBChannelWiseViewModel
import com.licapps.bmmis.ui.viewmodels.NBForDayViewModel
import com.licapps.bmmis.ui.viewmodels.ResBuildingViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NBChannelWiseFragment : Fragment() {

    private var binding: FragmentNbForDayBinding by autoCleared()
    private val viewModel: NBChannelWiseViewModel by viewModels()
    private lateinit var adapter: NBForDayListAdapter
    private var bocItemList = ArrayList<ChannelwiseNB>()
    private val apiRequest = CommonReq()
    private var sortFPAsc=true
    private var sortNOPAsc=true;


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
        binding.activisationMTV.visibility=View.GONE
        viewModel.getChannelWiseNB(apiRequest);
        setupRecyclerView()
        setupObservers()
        setOnClickFun()

    }





    private fun setupRecyclerView() {
        adapter = NBForDayListAdapter(ScreenName.CHANNELWISE_NB.value)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }

    private fun setOnClickFun(){

        binding.nopMTV.setOnClickListener {

            sortResult(AppConstants.SORT_NOP)
        }
        binding.fpMTV.setOnClickListener {
            sortResult(AppConstants.SORT_FP)
        }

    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {

                            bocItemList= it.data.data as ArrayList<ChannelwiseNB>
                            addTotalItem()
                            binding.noResultIV.visibility = View.GONE
                            sortResult(AppConstants.SORT_NOP)
                          //  adapter.setItems(bocItemList)
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

        var channelwiseNB: ChannelwiseNB
        if(bocItemList!=null && bocItemList.size>0)
        {
            channelwiseNB= ChannelwiseNB()
            var totalNOP=0
            var totalFPI:Int=0
            for (item in bocItemList) {
                totalNOP=totalNOP+item.nop.toInt();
                totalFPI=totalFPI+item.amount.toInt();
            }

            channelwiseNB.nop=totalNOP.toString()
            channelwiseNB.amount=totalFPI.toString()
            channelwiseNB.type= AppConstants.TOTAL
            bocItemList.add(channelwiseNB)
        }

    }

    private fun sortResult(sortFilter:String )
    {
        if(!bocItemList.isNullOrEmpty()) {
            var totalItem: ChannelwiseNB = bocItemList.get(bocItemList.size - 1);
            var bocListSorted = ArrayList<ChannelwiseNB>()
            bocListSorted.addAll(bocItemList)
            bocListSorted.remove(totalItem);

            binding.nopMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            binding.fpMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            when (sortFilter) {
                AppConstants.SORT_NOP -> {
                    if (sortNOPAsc) {
                        bocListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nop.toInt() > rhs.nop.toInt()) -1 else if (lhs.nop.toInt() < rhs.nop.toInt()) 1 else 0
                        })
                        binding.nopMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        bocListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nop.toInt() < rhs.nop.toInt()) -1 else if (lhs.nop.toInt() > rhs.nop.toInt()) 1 else 0
                        })
                        binding.nopMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortNOPAsc = !sortNOPAsc
                }

                AppConstants.SORT_FP -> {
                    if (sortFPAsc) {
                        bocListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.amount.toDouble() > rhs.amount.toDouble()) -1 else if (lhs.amount.toDouble() < rhs.amount.toDouble()) 1 else 0
                        })
                        binding.fpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        bocListSorted.sortWith(Comparator { lhs, rhs ->
                            if (lhs.amount.toDouble() < rhs.amount.toDouble()) -1 else if (lhs.amount.toDouble() > rhs.amount.toDouble()) 1 else 0
                        })
                        binding.fpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortFPAsc = !sortFPAsc
                }


            }
            bocListSorted.add(totalItem)
            adapter.setItems(bocListSorted)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_sort).isVisible=true
        menu.findItem(R.id.action_sort_nop).isVisible=true
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