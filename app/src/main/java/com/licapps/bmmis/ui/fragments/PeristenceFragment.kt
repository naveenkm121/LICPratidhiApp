package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.inactive.Inactive
import com.licapps.bmmis.data.model.persistence.Persistence
import com.licapps.bmmis.data.model.persistence.PersistenceData
import com.licapps.bmmis.data.model.persistence.PersistenceRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.databinding.FragmentPeristenceBinding
import com.licapps.bmmis.databinding.FragmentResBuildingBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.NBForDayListAdapter
import com.licapps.bmmis.ui.adapters.ResBuildingListAdapter
import com.licapps.bmmis.ui.viewmodels.InactiveViewModel
import com.licapps.bmmis.ui.viewmodels.PersistenceViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PeristenceFragment : Fragment() {

    private var binding: FragmentPeristenceBinding by autoCleared()
    private val viewModel: PersistenceViewModel by viewModels()
    private lateinit var adapter: NBForDayListAdapter
    private var persistenceList = ArrayList<Persistence>()
    private val apiRequest = CommonReq()
    private var whichRequest  = 1



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeristenceBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch = (activity as NewHomeActivity).branch
        setupRecyclerView()
        setupObservers()
        setRadioButtons()
        binding.onPolicyMRB.isChecked=true

    }


    private fun setRadioButtons() {
        binding.filterRadioRG.setOnCheckedChangeListener { group, id ->
            when (id) {
                R.id.onPolicyMRB -> {
                    whichRequest=0
                    setHeaderUI()
                    viewModel.getPersistenceData(apiRequest,whichRequest)
                }
                R.id.onPremiumMRB -> {
                    whichRequest=1
                    setHeaderUI()
                    viewModel.getPersistenceData(apiRequest,whichRequest)
                }
            }

        }
    }

    private fun setHeaderUI() {
        if(whichRequest==0) {
            binding.noPolMTV.text = getString(R.string.no_pol)

            binding.totalMTV.text = getString(R.string.total_pol)
        }
        else
        {
            binding.noPolMTV.text = getString(R.string.prem)

            binding.totalMTV.text = getString(R.string.total_prem)
        }
    }


    private fun setupRecyclerView() {
        adapter = NBForDayListAdapter(ScreenName.PERSISTENCY.value)
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
                            populateItemAndSetAdapterList(it.data.data[0])
                            binding.noResultIV.visibility = View.GONE
                         //   sortResult(AppConstants.SORT_FOR_DAYS)

                        } else {
                            binding.noResultIV.visibility = View.VISIBLE

                        }
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                }
                Resource.Status.ERROR -> {
                    setProgressBar(false)
                    if (it.message?.contains("401") == true) {
                        Toast.makeText(
                                requireContext(),
                                R.string.session_expired,
                                Toast.LENGTH_SHORT
                        ).show()
                        activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };
                    } else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->
                    setProgressBar(true)
            }
        })

    }


    private fun populateItemAndSetAdapterList(persistenceData: PersistenceData){
        persistenceList.clear()

       persistenceList.add(Persistence(whichRequest,"13th\nMonth",persistenceData.pol13th_pers,persistenceData.pol13th_tot,CommonUtility.getPercentage(persistenceData.pol13th_pers,persistenceData.pol13th_tot)))
        persistenceList.add(Persistence(whichRequest,"25th\nMonth",persistenceData.pol25th_pers,persistenceData.pol25th_tot,CommonUtility.getPercentage(persistenceData.pol25th_pers,persistenceData.pol25th_tot)))
        persistenceList.add(Persistence(whichRequest,"37th\nMonth",persistenceData.pol37th_pers,persistenceData.pol37th_tot,CommonUtility.getPercentage(persistenceData.pol37th_pers,persistenceData.pol37th_tot)))
        persistenceList.add(Persistence(whichRequest,"49th\nMonth",persistenceData.pol49th_pers,persistenceData.pol49th_tot,CommonUtility.getPercentage(persistenceData.pol49th_pers,persistenceData.pol49th_tot)))
        persistenceList.add(Persistence(whichRequest,"61th\nMonth",persistenceData.pol61st_pers,persistenceData.pol61st_tot,CommonUtility.getPercentage(persistenceData.pol61st_pers,persistenceData.pol61st_tot)))
        adapter.setItems(persistenceList)
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