package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.licapps.bmmis.R
import com.licapps.bmmis.data.model.nbperformance.NBPerformance
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.databinding.FragmentNbuptodayBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.viewmodels.NBUptoDayViewModel
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.Resource
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NBPerformanceFragment : Fragment() {

    private var binding: FragmentNbuptodayBinding by autoCleared()
    private val viewModel: NBUptoDayViewModel by viewModels()
    private val apiRequest = CommonReq()
    private var whichRequest  = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNbuptodayBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        apiRequest.branch=(activity as NewHomeActivity).branch
        setupObservers()
        setRadioButtons()
       // viewModel.getTopPerformers(apiRequest,whichRequest )
        binding.growthMRB.isChecked=true

    }

    private fun setRadioButtons() {
       binding.filterRadioRG.setOnCheckedChangeListener { group, id ->
           when (id) {
               R.id.growthMRB -> {
                   whichRequest=0
                   viewModel.getNBUptoDay(apiRequest, whichRequest)
               }
               R.id.volumeMRB -> {
                   whichRequest =1
                   viewModel.getNBUptoDay(apiRequest, whichRequest)
               }
               R.id.a2bMRB -> {
                   whichRequest =2
                   viewModel.getNBUptoDay(apiRequest, whichRequest)
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
                    binding.progressBar.progressBar.visibility = View.GONE
                    if (it.data != null&&it.data.status==1) {
                        if (it.data.data.isNotEmpty()) {
                            // binding.progressBar.visibility = View.GONE
                           // topPerformersList.clear()
                              setUpUI(it.data.data[0])

                            //binding.noResultIV.visibility = View.GONE


                        }
                    } else
                        Toast.makeText(
                            requireContext(),
                            R.string.err_in_response,
                            Toast.LENGTH_SHORT
                        ).show()

                }
                Resource.Status.ERROR -> {
                    binding.progressBar.progressBar.visibility = View.GONE
                    if(it.message?.contains("401")==true){
                        Toast.makeText(requireContext(), R.string.session_expired, Toast.LENGTH_SHORT).show()
                        activity?.let { it1 -> CommonUtility.logoutAppSession(it1) };
                    }
                    else
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING ->
                    binding.progressBar.progressBar.visibility = View.VISIBLE
            }
        })

    }

    private fun setUpUI(nbPerformance: NBPerformance) {

        binding.branchNameTV.text = "Branch: " + nbPerformance.branch_code
        if(whichRequest==2 || whichRequest==0) {


            binding.nopTV.text =  nbPerformance.nop +"%"
            binding.spTV.text =  nbPerformance.sp +"%"
            binding.nspTV.text =  nbPerformance.nsp +"%"
            binding.fyrpTV.text =  nbPerformance.fyrp +"%"
            binding.nppolTV.text =  nbPerformance.nppol +"%"
            binding.wrpTV.text = nbPerformance.wrp +"% "
        }else{

            binding.nopTV.text = nbPerformance.nop
            binding.spTV.text = CommonUtility.convertNumtoIndiaCurrency( nbPerformance.sp)
            binding.nspTV.text = CommonUtility.convertNumtoIndiaCurrency(nbPerformance.nsp)
            binding.fyrpTV.text = CommonUtility.convertNumtoIndiaCurrency( nbPerformance.fyrp)
            binding.nppolTV.text = nbPerformance.nppol
            binding.wrpTV.text =  CommonUtility.convertDoubletoIndiaCurrency(nbPerformance.wrp)
        }
    }
   /* private fun setProgressBar(b: Boolean) {
        if(!b){
            binding.progressBarShim.shimmerLayout.visibility = View.GONE
            binding.progressBarShim.shimmerLayout.showShimmer(false)
        }
        else
        {
            binding.progressBarShim.shimmerLayout.visibility = View.VISIBLE
            binding.progressBarShim.shimmerLayout.showShimmer(true)
        }
    }
*/

}
