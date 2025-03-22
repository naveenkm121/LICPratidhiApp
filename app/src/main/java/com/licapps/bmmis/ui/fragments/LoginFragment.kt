package com.licapps.bmmis.ui.fragments

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.data.model.login.LoginReq
import com.licapps.bmmis.data.model.login.LoginRes
import com.licapps.bmmis.data.model.util.AppDataInfo
import com.licapps.bmmis.databinding.LoginFragmentBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.ui.viewmodels.LoginViewModel
import com.licapps.bmmis.utils.*
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var binding: LoginFragmentBinding by autoCleared()
    private val viewModel: LoginViewModel by viewModels()
    private var loginRequest: LoginReq = LoginReq()
    var otpScreenList = listOf("S", "T", "Z", "B", "C", "K")
    var isOTPUser = false
    private lateinit var dialog: Dialog
    private var deviceId = ""
    private lateinit var appDataInfo: AppDataInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkLogin()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        appDataInfo = CommonUtility.getAppDataInfo(this.requireContext())
        setInitialData()
        setOnClickListeners()
        setupObservers()
        setInitialUI()
    }

    private fun setInitialUI() {
        var heading: String = ""
        var hint: String = ""

    }

    private fun setInitialData() {
        loginRequest.username = SaveSharedPreference.getUserDetails(context)?.sr_number.toString()

    }

    private fun checkLogin() {
        if (SaveSharedPreference.getLoggedStatus(context) == true)
            login(false, null)
        else
            SaveSharedPreference.logout(context)


    }

    private fun setOnClickListeners() {
        binding.signInBTN.setOnClickListener {
            UICommon.hideSoftKeyboard(binding.passwordET, activity as Activity)
            Timber.d(NetworkUtils.getIpAddress(requireContext()))
            var userId = binding.userIdET.text.toString().trim()
            var password = binding.passwordET.text.toString().trim()

            if (checkIdPwdValidation(userId, password)) {
                loginRequest.username = binding.userIdET.text.toString().trim()
                loginRequest.password = binding.passwordET.text.toString().trim().toString()
                viewModel.login(loginRequest)
            }

        }

    }

    private fun checkIdPwdValidation(userId: String, password: String): Boolean {
        return if (!userId.isNullOrBlank()) {
            if (userId.length != 6) {
                binding.userIdTIL.error = getString(R.string.err_sr_no)
                false

            } else {
                binding.userIdTIL.error = ""
                if (!password.isNullOrBlank()) {
                    binding.passwordTIL.error = ""
                    true
                } else {
                    binding.passwordTIL.error = getString(R.string.err_password_empty)
                    false
                }
            }

        } else {
            binding.userIdTIL.error = getString(R.string.err_userid_empty)
            false
        }
    }

    /*   private fun checkIdValidation(userCode: String?): Boolean {
           return if (!userCode.isNullOrBlank()) {
               binding.userCodeTIL.error = ""
               true

           } else {
               binding.userCodeTIL.error = getString(R.string.err_usercode_empty)
               false
           }
       }*/

    private fun showPinDialog(loginRes: LoginRes?) {

        dialog = MaterialAlertDialogBuilder(requireContext())
            .setView(R.layout.dailog_toset_pin)
            .create()

        //dialog.window!!.attributes.windowAnimations = com.licapps.ananda.R.style.DialogAnimation
        dialog.setCancelable(false)
        dialog.show()
        setPinDialogUI(loginRes)

    }

    private fun setPinDialogUI(loginRes: LoginRes?) {
        var pin1ET: EditText = dialog.findViewById(R.id.pin1ET)
        var pin2ET: TextInputEditText = dialog.findViewById<TextInputEditText>(R.id.pin2ET)
        var setPinBTN: MaterialButton? = dialog.findViewById(R.id.setPinBTN)

        setPinBTN?.setOnClickListener {

            var pin1 = pin1ET.text.toString()
            var pin2 = pin2ET.text.toString()
            if (validatePinSetData(pin1, pin2)) {
                if (SaveSharedPreference.setPin(
                        context,
                        EncryptUtil.get_SHA_512_SecurePassword(pin1)
                    ) == true
                ) {

                    Toast.makeText(
                        requireContext(),
                        getString(R.string.pin_success),
                        Toast.LENGTH_SHORT
                    )
                        .show()

                    dialog.dismiss()
                    login(true,loginRes)
                }
                // viewModel.setPin(setPinRequest)
                // viewModel.savePolicyDetails(prevPolicy)
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.invalid_input),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

            //findNavController().navigate(R.id.action_premCalcResultFragment_to_EKycFragment)
        }
    }

    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    // bindPlan(it.data!!)
                    //fragmentFeedbackBinding.progressBarLL.visibility = View.GONE
                    UICommon.hideProgressDialog(requireActivity())
                    if (it.data?.message?.startsWith(
                            AppConstants.SUCCESS,
                            true
                        ) == true && !it.data.token.isNullOrEmpty()
                    ) {
                        if (SaveSharedPreference.getPin(context).isNullOrEmpty())
                            showPinDialog(it.data)
                        else
                            login(true, it.data)
                        //compare hash string with recd hash

                    } else {
                        Timber.d(it.data?.message)
                        Toast.makeText(requireContext(), it.data?.message, Toast.LENGTH_SHORT)
                            .show()
                    }
                    //fragmentFeedbackBinding.feedbackBoxET.setText("")
                }

                Resource.Status.ERROR -> {
                    UICommon.hideProgressDialog(requireActivity())
                    Toast.makeText(
                        requireContext(),
                        if (it.data != null && it.data.message.isNotBlank()) it.data.message else it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }


                Resource.Status.LOADING -> {
                    UICommon.showProgressDialog(
                        requireActivity(),
                        getString(R.string.loading),
                        false
                    )
                }
            }
        }
        )
    }

    private fun validatePinSetData(pin1: String, pin2: String): Boolean {
        var isValid: Boolean
        if (pin1.isBlank() || pin1.length < AppConstants.PIN_LENGTH) {
            dialog.findViewById<TextInputLayout>(R.id.pin1TIL)!!.error =
                getString(R.string.enter_6_digits_pin)
            isValid = false
        } else if (pin2.isBlank() || pin2.length < AppConstants.PIN_LENGTH) {
            dialog.findViewById<TextInputLayout>(R.id.pin1TIL)!!.error = ""
            dialog.findViewById<TextInputLayout>(R.id.pin2TIL)!!.error =
                getString(R.string.enter_6_digits_pin)
            isValid = false
        } else if (pin1 != pin2) {
            dialog.findViewById<TextInputLayout>(R.id.pin1TIL)!!.error = ""
            dialog.findViewById<TextInputLayout>(R.id.pin2TIL)!!.error =
                getString(R.string.err_pin_match)
            isValid = false
        } else {
            dialog.findViewById<TextInputLayout>(R.id.pin1TIL)!!.error = ""
            dialog.findViewById<TextInputLayout>(R.id.pin2TIL)!!.error = ""
            isValid = true
        }
        return isValid
    }

    private fun login(saveDetails: Boolean, loginRes: LoginRes?) {
        if (saveDetails && loginRes != null)
            SaveSharedPreference.login(context, loginRes)
        val intent = Intent(activity, NewHomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }


}