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
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.emhr.EmhrData
import com.licapps.bmmis.data.model.emhr.EmhrReq
import com.licapps.bmmis.data.model.mab.MABItem
import com.licapps.bmmis.data.model.nbforday.NBForDayItem
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.FragmentAnadaEmhrBinding
import com.licapps.bmmis.databinding.FragmentNbForDayBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.EMHRListAdapter
import com.licapps.bmmis.ui.adapters.NBForDayListAdapter
import com.licapps.bmmis.ui.viewmodels.EMHRViewModel
import com.licapps.bmmis.ui.viewmodels.NBForDayViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnadaEMHRFragment :  Fragment(),EMHRListAdapter.CardItemListener {

    private var binding: FragmentAnadaEmhrBinding by autoCleared()
    private val viewModel: EMHRViewModel by viewModels()
    private lateinit var adapter: EMHRListAdapter
    private val apiRequest = EmhrReq()
    private var emhrList = ArrayList<EmhrData>()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnadaEmhrBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
        apiRequest.srno="630922"
        viewModel.getEMHRData(apiRequest);
        setupRecyclerView()
        setupObservers()


    }





    private fun setupRecyclerView() {
        adapter = EMHRListAdapter(this)
        binding.recylerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recylerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {

                            binding.noResultIV.visibility = View.GONE
                            emhrList= it.data.data as ArrayList<EmhrData>
                            adapter.setItems(emhrList)
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

    override fun onClickedCard(cardName: String) {
        DebugHandler.log("Heeelow Aananda dffgd")
        CommonUtility.launchBrowser(requireContext(),AppConstants.EMHR_ANANDA_URL)
    }


}