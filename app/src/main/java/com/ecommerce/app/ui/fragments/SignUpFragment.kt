package com.ecommerce.app.ui.fragments

import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ecommerce.app.R
import com.ecommerce.app.constants.AppConstants
import com.ecommerce.app.data.login.LoginReq
import com.ecommerce.app.data.login.LoginRes
import com.ecommerce.app.data.login.SignupReq
import com.ecommerce.app.databinding.FragmentSignupBinding
import com.ecommerce.app.ui.activities.HomeActivity
import com.ecommerce.app.ui.viewmodels.LoginViewModel

import com.ecommerce.app.ui.viewmodels.SignUpViewModel
import com.ecommerce.app.utils.CommonUtility
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.SaveSharedPreference
import com.ecommerce.app.utils.autoCleared

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private val viewModel: SignUpViewModel by viewModels()
    private var binding: FragmentSignupBinding by autoCleared()
    private var signupReq: SignupReq = SignupReq()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInitialUI()
        setupObservers()
        setOnClickListener()

    }

    private fun setupInitialUI() {
        //  binding.userNameET.addTextChangedListener(textWatcher)
        //  binding.emailET.addTextChangedListener(textWatcher)
        //   binding.mobileET.addTextChangedListener(textWatcher)
        //   binding.passwordET.addTextChangedListener(textWatcher)


    }


    private fun validateInput(): Boolean {
        val username = binding.userNameET.text.toString()
        val email = binding.emailET.text.toString()
        val mobile = binding.mobileET.text.toString()
        val password = binding.passwordET.text.toString()

        // Validate input fields and update UI accordingly
        if (username.isEmpty()) {
            binding.userNameTIL.error = getString(R.string.err_username_empty)
            return false
        } else {
            binding.userNameTIL.error = null
        }

        if (!CommonUtility.isValidEmail(email)) {
            binding.emailTIL.error = getString(R.string.err_email)
            return false
        } else {
            binding.emailTIL.error = null
        }

        if (!CommonUtility.isValidPhoneNumber(mobile)) {
            binding.mobileTIL.error = getString(R.string.err_mobile)
            return false
        } else {
            binding.mobileTIL.error = null
        }

        if (password.length < 6) {
            binding.passwordTIL.error = getString(R.string.err_password)
            return false
        } else {
            binding.passwordTIL.error = null
        }

        return true
    }


    private fun setOnClickListener() {
        binding.signupBTN.setOnClickListener {
            if (validateInput()) {
                signupReq.name = binding.userNameET.text.toString()
                signupReq.email = binding.emailET.text.toString()
                signupReq.mobile = binding.mobileET.text.toString()
                signupReq.password = binding.passwordET.text.toString()
                viewModel.getSignup(signupReq)
            }
        }

        binding.loginRL.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }
    }

    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceViewState.Status.LOADING -> {
                    setProgressBar(true)
                }

                ResourceViewState.Status.SUCCESS -> {
                    setProgressBar(false)
                    if (it.data?.message?.startsWith(AppConstants.SUCCESS, true) == true) {
//                        if (SaveSharedPreference.getPin(context).isNullOrEmpty())
//                            showPinDialog(it.data)
//                        else
//                            login(true, it.data)
                        //compare hash string with recd hash
                        launchHomePage(true, it.data)

                    } else {
                        DebugHandler.log(it.data?.message)
                        Toast.makeText(requireContext(), it.data?.message, Toast.LENGTH_SHORT)
                            .show()
                    }


                }

                ResourceViewState.Status.ERROR -> {
                    setProgressBar(false)
                }
            }

        })
    }

    private fun launchHomePage(saveDetails: Boolean, loginRes: LoginRes?) {

        if (saveDetails && loginRes != null)
            SaveSharedPreference.login(context, loginRes)

        val intent = Intent(activity, HomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        startActivity(intent)
    }

    private fun setProgressBar(b: Boolean) {
        if (!b) {
            binding.progressBar.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.VISIBLE
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        //binding = null
    }
}