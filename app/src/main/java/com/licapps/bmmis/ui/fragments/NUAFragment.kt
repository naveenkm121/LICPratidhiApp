package com.licapps.bmmis.ui.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.mab.MABItem
import com.licapps.bmmis.data.model.nua.NuaData
import com.licapps.bmmis.data.model.nua.NuaReq
import com.licapps.bmmis.data.model.persistence.Persistence
import com.licapps.bmmis.data.model.persistence.PersistenceData
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.databinding.FragmentNuaBinding
import com.licapps.bmmis.databinding.FragmentPeristenceBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.NBForDayListAdapter
import com.licapps.bmmis.ui.adapters.NuaListAdapter
import com.licapps.bmmis.ui.viewmodels.NUAViewmodel
import com.licapps.bmmis.ui.viewmodels.PersistenceViewModel
import com.licapps.bmmis.utils.*
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class NUAFragment : Fragment() {

    private var binding: FragmentNuaBinding by autoCleared()
    private val viewModel: NUAViewmodel by viewModels()
    private lateinit var adapter: NuaListAdapter
    private var nuaDataList = ArrayList<NuaData>()
    private val apiRequest = NuaReq()
    private var isProposalSelected=true;



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNuaBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.bocode = (activity as NewHomeActivity).branch
        setRadioButtons()
        setOnClickListeners()
        setupRecyclerView()
        setupObservers()

    }



    private fun setRadioButtons() {

        binding.filterRadioRG.setOnCheckedChangeListener { group, id ->
            when (id) {
                R.id.proposalMRB -> {
                    isProposalSelected=true;
                    binding.proposalLL.visibility=View.VISIBLE
                    binding.sheetNumberTIL.visibility=View.GONE
                    adapter.clear()


                }
                R.id.ratingSheetMRB -> {
                    isProposalSelected=false;
                    binding.proposalLL.visibility=View.GONE
                    binding.sheetNumberTIL.visibility=View.VISIBLE
                    adapter.clear()
                }
            }

        }
    }


    private fun setOnClickListeners() {

        binding.searchBTN.setOnClickListener {

            UICommon.hideSoftKeyboard(binding.sheetNumberET, activity as Activity)

            if(isProposalSelected)
            {
                var proposalNumber = binding.proposalET.text.toString().trim()
                var finYear = binding.yearET.text.toString().trim()

                if((proposalNumber!=null && !proposalNumber.equals(""))&&(finYear!=null && !finYear.equals(""))){
                    apiRequest.pplno = proposalNumber
                    apiRequest.finyear = finYear
                    apiRequest.ratingsheetNo=""
                    binding.proposalTIL.error =""
                    binding.yearTIL.error =""

                    viewModel.getNuaData(apiRequest)

                }else{

                    binding.proposalTIL.error ="Proposal Number is required "
                    binding.yearTIL.error ="Financial Year is required"

                }
            }else {
                var sheetNumber = binding.sheetNumberET.text.toString().trim()

                if (sheetNumber != null && !sheetNumber.equals("")) {
                    //sheetNumber="73435225"
                    apiRequest.ratingsheetNo = sheetNumber
                    apiRequest.pplno=""
                    apiRequest.finyear=""
                    binding.sheetNumberTIL.error =""
                    adapter.clear()
                    viewModel.getNuaData(apiRequest)

                } else {
                    binding.sheetNumberTIL.error = "Please enter the Rating Sheet Number"

                }
            }
        }

    }




    private fun setupRecyclerView() {
        adapter = NuaListAdapter(ScreenName.NUA.value)
        binding.nuaRV.layoutManager = LinearLayoutManager(requireContext())
        binding.nuaRV.adapter = adapter
    }



    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null ) {
                        if (it.data.data.isNotEmpty() && it.data.status==1) {
                            nuaDataList= it.data.data as ArrayList<NuaData>
                            binding.noResultIV.visibility = View.GONE
                            binding.nuaRV.visibility=View.VISIBLE
                            adapter.setItems(nuaDataList)


                        } else {
                            binding.noResultIV.visibility = View.VISIBLE
                            binding.nuaRV.visibility=View.GONE

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