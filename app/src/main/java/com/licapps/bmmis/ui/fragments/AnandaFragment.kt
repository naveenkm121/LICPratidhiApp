package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.licapps.bmmis.R
import com.licapps.bmmis.data.model.ananda.AnandaItem
import com.licapps.bmmis.data.model.ananda.AnandaRes
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.FragmentAnandaBinding
import com.licapps.bmmis.databinding.FragmentTopPerformersBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.TopPerformersListAdapter
import com.licapps.bmmis.ui.viewmodels.AnandaViewModel
import com.licapps.bmmis.ui.viewmodels.TopPerformersViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnandaFragment : Fragment(), TopPerformersListAdapter.CasesListItemListener {

    private var binding: FragmentAnandaBinding by autoCleared()
    private val viewModel: AnandaViewModel by viewModels()
    private val apiRequest = CommonReq()
    private var whichRequest  = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnandaBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
        setupObservers()
        setRadioButtons()
       binding.uptoDateMRB.isChecked=true

    }



    private fun setRadioButtons() {
       binding.filterRadioRG.setOnCheckedChangeListener { group, id ->
           when (id) {
               R.id.forDayMRB -> {
                   whichRequest=0
                   viewModel.getAnandaData(apiRequest)
               }
               R.id.uptoDateMRB -> {
                   whichRequest=1
                   viewModel.getAnandaData(apiRequest)
               }
           }

       }
    }

    private fun setInitialUI(screenToShow: String) {

    }


    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {
                            // binding.progressBar.progressBar.visibility = View.GONE
                           // topPerformersList.clear()
                               setData(it.data.data[0])
                            binding.noResultIV.visibility = View.GONE

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
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->{
                    setProgressBar(true)
                }

            }
        })

    }

    private fun setData(anandaRes: AnandaItem) {
        when(whichRequest){
            0->{
                binding.tNopMTV.text=anandaRes.fnop
                binding.tFpiMTV.text=CommonUtility.convertDoubletoIndiaCurrency(anandaRes.ffp)
                binding.tActiveMTV.text=anandaRes.fact
            }
            1->{
                binding.tNopMTV.text=anandaRes.unop
                binding.tFpiMTV.text=CommonUtility.convertDoubletoIndiaCurrency(anandaRes.ufp)
                binding.tActiveMTV.text=anandaRes.uact
            }
        }
        binding.dataCardView.visibility=View.VISIBLE
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
