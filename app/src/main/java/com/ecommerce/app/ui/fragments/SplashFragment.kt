package com.ecommerce.app.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ecommerce.app.R
import com.ecommerce.app.constants.SharedPrefs
import com.ecommerce.app.databinding.FragmentSplashBinding
import com.ecommerce.app.ui.activities.HomeActivity
import com.ecommerce.app.ui.viewmodels.SplashViewModel
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.SaveSharedPreference
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private val SPLASH_DELAY_TIME: Long = 2000 // 2 seconds delay

    private var binding :FragmentSplashBinding by autoCleared()
    private val viewModel:SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // launchLogin()
        Handler().postDelayed({
            // Start your next activity here
            if(SaveSharedPreference.getTokenValue(requireContext()).isNullOrEmpty())
            {
                DebugHandler.log("HEllo launchLogin")
                launchLogin()
            }else{
                DebugHandler.log("HEllo launchHomeActivity")
                launchHomeActivity()
            }

        }, SPLASH_DELAY_TIME)

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


    fun launchHomeActivity() {
        val intent = Intent(activity, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }

}