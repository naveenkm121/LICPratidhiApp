package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ecommerce.app.R
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.databinding.FragmentAddAddressBinding
import com.ecommerce.app.databinding.FragmentAddressBinding
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.SaveSharedPreference
import com.ecommerce.app.utils.autoCleared


class AddAddressFragment : Fragment() {
    private var binding: FragmentAddAddressBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DebugHandler.log("Session =="+ SaveSharedPreference.getTokenValue(requireContext()))
    }
}