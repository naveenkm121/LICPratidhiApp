package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.licapps.bmmis.R
import com.licapps.bmmis.databinding.FragmentNewHomeBinding
import com.licapps.bmmis.ui.adapters.HomeAdapter
import com.licapps.bmmis.ui.viewmodels.HomeViewModel
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewHomeFragment : Fragment(){

    private var binding: FragmentNewHomeBinding by autoCleared()
    var firstTimeOnHome = true
    private lateinit var homeViewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentNewHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (firstTimeOnHome) {
            firstTimeOnHome = false
            //context?.let { UICommon.showWebViewAlertDialog(it,str, R.layout.dialog_webview) }
        }
        setOnClickListeners()
        //  setInfoText()

    }

    private fun setOnClickListeners() {
        binding.branchBusTracCV.setOnClickListener {
            findNavController().navigate(R.id.action_newHomeFragment_to_homeFragment)
        }
        binding.greetingsCV.setOnClickListener {
            findNavController().navigate(R.id.action_newHomeFragment_to_wishesFragment)
        }
    }

}