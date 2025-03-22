package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.mab.MABItem
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.databinding.FragmentMabBinding
import com.licapps.bmmis.databinding.FragmentProspectiveNewBinding
import com.licapps.bmmis.ui.adapters.MABListAdapter
import com.licapps.bmmis.ui.viewmodels.MABViewModel
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProspectiveNewFragment : Fragment() {



        private var binding: FragmentProspectiveNewBinding by autoCleared()



        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentProspectiveNewBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
            setOnClickListeners()

        }

        private fun setOnClickListeners() {
            binding.mdrtCardView.setOnClickListener {
                findNavController().navigate(R.id.action_psopectiveFragment_to_prospectiveDetailsFragment,
                    bundleOf( IntentConstants.CASES_REQ_SCREEN to ScreenName.PROSPECTIVE_FP.value))
            }
            binding.commCardView.setOnClickListener {
                findNavController().navigate(R.id.action_psopectiveFragment_to_prospectiveDetailsFragment,
                    bundleOf(IntentConstants.CASES_REQ_SCREEN to ScreenName.PROSPECTIVE_MDRT_COMM.value))
            }
            binding.centurionCardView.setOnClickListener {
                findNavController().navigate(R.id.action_psopectiveFragment_to_prospectiveDetailsFragment,
                    bundleOf( IntentConstants.CASES_REQ_SCREEN to ScreenName.PROSPECTIVE_CENTURION.value))
            }


        }

    }