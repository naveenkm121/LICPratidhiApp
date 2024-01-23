package com.ecommerce.app.ui.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.ecommerce.app.R
import com.ecommerce.app.databinding.FragmentHomeBinding
import com.ecommerce.app.databinding.FragmentSplashBinding
import com.ecommerce.app.ui.viewmodels.SplashViewModel
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var binding :FragmentSplashBinding by autoCleared()
    private val viewModel:SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchLogin()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun launchLogin() {
        findNavController().navigate(R.id.action_splashFragment_to_loginFragment)

    }

}