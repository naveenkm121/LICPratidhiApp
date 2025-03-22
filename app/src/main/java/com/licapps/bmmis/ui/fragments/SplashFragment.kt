package com.licapps.bmmis.ui.fragments


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.data.model.login.LoginData
import com.licapps.bmmis.data.model.login.LoginReq
import com.licapps.bmmis.data.model.util.LaunchRes
import com.licapps.bmmis.databinding.FragmentSplashBinding
import com.licapps.bmmis.ui.viewmodels.SplashViewModel
import com.licapps.bmmis.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var binding: FragmentSplashBinding by autoCleared()
    private val viewModel: SplashViewModel by viewModels()
    private var mpin:String=""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInitialData()
        setupObservers()
        setAnimation()
        viewModel.getLaunchStatus("")


    }

    private fun setInitialData() {
        mpin= SaveSharedPreference.getPin(context).toString()

    }

    private fun setAnimation()
    {
        val topAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.splash_top_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.splash_bottom_animation)

        binding.licLogoIV.startAnimation(topAnimation)
    }

    private fun setupObservers() {
        viewModel.response.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {

                    if (it.data?.message != null && it.data?.message.equals(
                            AppConstants.SUCCESS,
                            true
                        )
                    ) {
                        var appVersionName: String =
                            CommonUtility.getAppVersionName(requireContext())
                        var appversionNumber: Long =
                            CommonUtility.getAppVersionCode(requireContext())
                        DebugHandler.log("app Version :: " + appVersionName.toFloat() + " appversionNumber" + appversionNumber)

                        if (it.data.toShowNew.equals(AppConstants.APP_MAINTAINANCE_KEY) || it.data.toShowNew.equals(
                                AppConstants.APP_UPDATE_KEY
                            )
                        ) {
                            showUpdateDialog(it.data)
                        } else {
                            if(mpin.isNullOrEmpty()) {
                                launchLogin()
                            }else{
                                launchMPIN()
                            }


                        }

                    }


                }

                Resource.Status.ERROR ->
                    //launchLogin()
                    Toast.makeText(activity, getString(R.string.server_down), Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {

                }
            }
        })
    }


    private fun showUpdateDialog(launchRes: LaunchRes) {

        var dialog: Dialog = MaterialAlertDialogBuilder(requireContext())
            .setView(R.layout.dialog_launch_app)
            .create()
        dialog.setCancelable(false)
        dialog.show()
        var messageTV: TextView? = dialog.findViewById<TextView>(R.id.messageTV)
        var updateBTN: MaterialButton? = dialog.findViewById(R.id.updateBTN)
        var okBTN: MaterialButton? = dialog.findViewById(R.id.okBTN)
        okBTN?.visibility = View.GONE
        updateBTN?.visibility = View.GONE
        messageTV?.setText(launchRes.msgText.toString())

        var appVersionName: String = CommonUtility.getAppVersionName(requireContext())
        if (launchRes.toShowNew.equals(AppConstants.APP_UPDATE_KEY)) {
            try {
                if (launchRes.versionName.toFloat() > appVersionName.toFloat()) {
                    updateBTN?.visibility = View.VISIBLE
                } else {
                    updateBTN?.visibility = View.GONE
                    dialog.dismiss()
                    //launchLogin()
                    if(mpin.isNullOrEmpty()) {
                        launchLogin()
                    }else{
                        launchMPIN()
                    }



                }
            } catch (e: Exception) {
                e.printStackTrace()
                launchLogin()
            }

        }

        if (launchRes.isCancellable) {
            okBTN?.visibility = View.VISIBLE
        } else {
            okBTN?.visibility = View.GONE
        }


        okBTN?.setOnClickListener {
            dialog.dismiss()
            launchLogin()
        }
        updateBTN?.setOnClickListener {

            CommonUtility.launchPlayStore(requireContext(), AppConstants.APP_PACKAGE_NAME)
        }


    }

    private fun launchLogin() {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)

        }

    private fun launchMPIN() {
        findNavController().navigate(R.id.action_splashFragment_to_mpinFragment)
    }



}
