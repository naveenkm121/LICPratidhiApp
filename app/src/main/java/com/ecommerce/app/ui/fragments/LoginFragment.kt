package com.ecommerce.app.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
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
import com.ecommerce.app.databinding.FragmentLoginBinding
import com.ecommerce.app.ui.activities.HomeActivity
import com.ecommerce.app.ui.viewmodels.LoginViewModel
import com.ecommerce.app.utils.CommonUtility
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.SaveSharedPreference
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private var binding: FragmentLoginBinding by autoCleared()
    private var loginReq: LoginReq = LoginReq()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInitialUI()
        setOnClickListener()
        setupObservers()

    }

    private fun setInitialUI() {
        binding.userIdET.setText("micki@gmail.com")
        binding.passwordET.setText("naveen")

    }

    private fun setOnClickListener() {

        binding.loginBTN.setOnClickListener {
            // UICommon.hideSoftKeyboard(binding.passwordET, activity as Activity)
            // Timber.d(NetworkUtils.getIpAddress(requireContext()))
            var userId = binding.userIdET.text.toString().trim()
            var password = binding.passwordET.text.toString().trim()

            if (isValidInputData(userId, password)) {
                loginReq.username = binding.userIdET.text.toString().trim()
                loginReq.password = binding.passwordET.text.toString().trim()
                viewModel.getLogin(loginReq)
            }
        }

        binding.signupRL.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }


    private fun isValidInputData(email: String, password: String): Boolean {

        return if (!email.isNullOrBlank() && CommonUtility.isValidEmail(email)) {
            binding.userIdTIL.error = ""

            if (!password.isNullOrBlank()) {
                binding.passwordTIL.error = ""
                true
            } else {
                binding.passwordTIL.error = getString(R.string.err_password_empty)
                false
            }

        } else {
            binding.userIdTIL.error = getString(R.string.err_email)
            false
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
                    if (it.data?.message?.startsWith(
                            AppConstants.SUCCESS,
                            true
                        ) == true && !it.data.token.isNullOrEmpty()
                    ) {
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
                    setProgressBar(true)
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


}