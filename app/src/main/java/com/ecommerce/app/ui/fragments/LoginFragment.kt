package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ecommerce.app.R
import com.ecommerce.app.constants.IntentConstants
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.databinding.FragmentLoginBinding
import com.ecommerce.app.databinding.FragmentProductDetailBinding
import com.ecommerce.app.ui.viewmodels.LoginViewModel
import com.ecommerce.app.ui.viewmodels.ProductDetailViewModel
import com.ecommerce.app.utils.GsonHelper
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private var binding:FragmentLoginBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListener()

    }

    private fun setOnClickListener(){
        binding.signupRL.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

}