package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.IntentConstants
import com.licapps.bmmis.data.model.mab.MABItem
import com.licapps.bmmis.data.model.prospectives.CommonReq
import com.licapps.bmmis.databinding.FragmentMabBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.adapters.MABListAdapter
import com.licapps.bmmis.ui.viewmodels.MABViewModel
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MABFragment : Fragment() {

    private var binding: FragmentMabBinding by autoCleared()
    private val viewModel: MABViewModel by viewModels()
    private lateinit var adapter: MABListAdapter
    private var bocItemList = ArrayList<MABItem>()
    private val apiRequest = CommonReq()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMabBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        setOnClickListeners()

    }

    private fun setOnClickListeners() {
        binding.cardViewAprilBt8New1.setOnClickListener {
            navigateToMABDetails("4")
        }
        binding.cardViewMayBt8New1.setOnClickListener {
            navigateToMABDetails("5")
        }
        binding.cardViewJuneBt8New1.setOnClickListener {
            navigateToMABDetails("6")
        }
        binding.cardViewJulyBt8New1.setOnClickListener {
            navigateToMABDetails("7")
        }
        binding.cardViewAugBt8New1.setOnClickListener {
            navigateToMABDetails("8")
        }
        binding.cardViewSeptBt8New1.setOnClickListener {
            navigateToMABDetails("9")
        }
        binding.cardViewOctBt8New1.setOnClickListener {
            navigateToMABDetails("10")
        }
        binding.cardViewNovBt8New1.setOnClickListener {
            navigateToMABDetails("11")
        }
        binding.cardViewDecBt8New1.setOnClickListener {
            navigateToMABDetails("12")
        }
        binding.cardViewJanBt8New1.setOnClickListener {
            navigateToMABDetails("1")
        }
        binding.cardViewFebBt8New1.setOnClickListener {
            navigateToMABDetails("2")
        }
        binding.cardViewMarBt8New1.setOnClickListener {
            navigateToMABDetails("3")
        }
    }

    private fun navigateToMABDetails(month: String) {
        findNavController().navigate(
            R.id.action_mabFragment_to_mabDetailsFragment,
            bundleOf(IntentConstants.MAB_MONTH to month)
        )
    }

}