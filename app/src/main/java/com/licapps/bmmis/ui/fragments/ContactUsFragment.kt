package com.licapps.bmmis.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.databinding.FragmentContactUsBinding
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactUsFragment : Fragment() {

    private var binding: FragmentContactUsBinding by autoCleared()


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = FragmentContactUsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {


        binding.feedbackBTN.setOnClickListener {

            var mailSubject: String = "App Feedback (Version : " + CommonUtility.getAppVersionName(requireContext()) + ", "+ CommonUtility.getAppVersionCode(requireContext())+", "+CommonUtility.getDeviceName()+" )"
            CommonUtility.composeEmail(requireContext(), AppConstants.CONTACT_US_EMAIL, mailSubject)

        }

    }


}