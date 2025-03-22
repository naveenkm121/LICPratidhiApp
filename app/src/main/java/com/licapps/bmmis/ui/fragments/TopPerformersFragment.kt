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
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.FragmentTopPerformersBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.TopPerformersListAdapter
import com.licapps.bmmis.ui.viewmodels.TopPerformersViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopPerformersFragment : Fragment(), TopPerformersListAdapter.CasesListItemListener {

    private var binding: FragmentTopPerformersBinding by autoCleared()
    private val viewModel: TopPerformersViewModel by viewModels()
    private lateinit var adapter: TopPerformersListAdapter
    private var topPerformersList = ArrayList<Performer>()
    private val apiRequest = CommonReq()
    private var whichRequest  = 0
    private var type  = 0
    private var sortFPAsc=true
    private var sortNOPAsc=true;
    private var isNOPSelected=true;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopPerformersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
        setupRecyclerView()
        setupObservers()
        setRadioButtons()
        setChipsGroup()
        setOnClickHandle()
       // viewModel.getTopPerformers(apiRequest,whichRequest )
        binding.doChip.isChecked=true

    }

    private fun setChipsGroup() {
        binding.performersChipCG.setOnCheckedChangeListener { group, id -> when (id) {
                    R.id.doChip -> {
                        whichRequest=0
                       binding.filterRadioRG.clearCheck()
                       binding.nopMRB.isChecked=true
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorHomeCardBg));

                    }
                    R.id.agentChip -> {
                        whichRequest=2
                        binding.filterRadioRG.clearCheck()
                        binding.nopMRB.isChecked=true
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorHomeCardBg));
                    }
                    R.id.cliaChip -> {
                        whichRequest=4
                        binding.filterRadioRG.clearCheck()
                        binding.nopMRB.isChecked=true
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorHomeCardBg));

                    }
                }

        }
    }

    private fun setRadioButtons() {
       binding.filterRadioRG.setOnCheckedChangeListener { group, id ->
           when (id) {
               R.id.nopMRB -> {
                        isNOPSelected=true;
                       adapter.clear()
                       type=whichRequest
                       viewModel.getTopPerformers(apiRequest, type)
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorHomeCardBg));


               }
               R.id.fpMRB -> {
                   isNOPSelected=false;
                       adapter.clear()
                       type = whichRequest + 1
                       viewModel.getTopPerformers(apiRequest, type)
                   binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorHomeCardBg));

               }
           }

       }
    }


    private fun setOnClickHandle(){

        binding.nopfpMTV.setOnClickListener {

            if(isNOPSelected)
                sortResult(AppConstants.SORT_NOP)
            else
                sortResult(AppConstants.SORT_FP)
        }


    }

    private fun setupRecyclerView() {
        adapter = TopPerformersListAdapter(this)
        binding.casesRV.layoutManager = LinearLayoutManager(requireContext())
        binding.casesRV.adapter = adapter
    }


    private fun setupObservers() {
        viewModel.responseNOP.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null) {
                        if (it.data.data.isNotEmpty()) {
                            // binding.progressBar.visibility = View.GONE
                           // topPerformersList.clear()
                               topPerformersList= it.data.data as ArrayList<Performer>

                            topPerformersList.forEachIndexed {index, it1->
                                run {
                                    it1.srno =index+1
                                    it1.type = type
                                }
                            }
                            binding.noResultIV.visibility = View.GONE
                            adapter.setItems(topPerformersList)
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

    override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_sort).isVisible=true
        val  sortFBMenu=menu.findItem(R.id.action_sort_fp)
        sortFBMenu.isVisible=true
        sortFBMenu.title="Sort by NOP/FP"


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_sort_fp -> {

                if(isNOPSelected)
                    sortResult(AppConstants.SORT_NOP)
                else
                    sortResult(AppConstants.SORT_FP)

                true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }



    private fun sortResult(sortFilter:String )
    {
        if(!topPerformersList.isNullOrEmpty()) {


          //  binding.nopMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            when (sortFilter) {
                AppConstants.SORT_NOP -> {
                    if (sortNOPAsc) {
                        topPerformersList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nop.toInt() > rhs.nop.toInt()) -1 else if (lhs.nop.toInt() < rhs.nop.toInt()) 1 else 0
                        })
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));

                    } else {
                        topPerformersList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.nop.toInt() < rhs.nop.toInt()) -1 else if (lhs.nop.toInt() > rhs.nop.toInt()) 1 else 0
                        })
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }

                    sortNOPAsc = !sortNOPAsc
                }

                AppConstants.SORT_FP -> {
                    if (sortFPAsc) {
                        topPerformersList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.fp.toDouble() > rhs.fp.toDouble()) -1 else if (lhs.fp.toDouble() < rhs.fp.toDouble()) 1 else 0
                        })
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortAsc));
                    } else {
                        topPerformersList.sortWith(Comparator { lhs, rhs ->
                            if (lhs.fp.toDouble() < rhs.fp.toDouble()) -1 else if (lhs.fp.toDouble() > rhs.fp.toDouble()) 1 else 0
                        })
                        binding.nopfpMTV.setBackgroundColor(getResources().getColor(R.color.colorSortDesc));
                    }
                    sortFPAsc = !sortFPAsc
                }


            }

            adapter.setItems(topPerformersList)
        }
    }

    override fun onClickedListItem(case: Performer) {
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
