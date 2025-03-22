package com.licapps.bmmis.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.MESSAGETYPE
import com.licapps.bmmis.databinding.FragmentMpinBinding
import com.licapps.bmmis.ui.activities.NewHomeActivity
import com.licapps.bmmis.utils.EncryptUtil
import com.licapps.bmmis.utils.SaveSharedPreference
import com.licapps.bmmis.utils.UICommon
import com.licapps.bmmis.utils.autoCleared

class MpinFragment : Fragment() {

    private var binding: FragmentMpinBinding by autoCleared()
    private var mpin: String = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMpinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //  screenToShow = arguments?.getString(IntentConstants.CASES_REQ_SCREEN).toString()
        mpin = SaveSharedPreference.getPin(context).toString()
        setOnClickListeners()

    }

    private fun setOnClickListeners() {

        binding.button0.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "0")
        }
        binding.button1.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "1")
        }
        binding.button2.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "2")
        }
        binding.button3.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "3")
        }
        binding.button4.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "4")
        }
        binding.button5.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "5")
        }
        binding.button6.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "6")
        }
        binding.button7.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "7")
        }
        binding.button8.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "8")
        }
        binding.button9.setOnClickListener {
            binding.mpinET.setText(binding.mpinET.text.toString().trim() + "9")
        }

        binding.buttonC.setOnClickListener(View.OnClickListener {
            val currentText: String = binding.mpinET.getText().toString() // + "";
            try {
                binding.mpinET.setText(currentText.substring(0, currentText.length - 1) + "")
            } catch (throwable: Throwable) {
            }
            binding.mpinET.setSelection(binding.mpinET.length())
        })

        binding.buttonForgot.setOnClickListener(View.OnClickListener {
            SaveSharedPreference.logout(context)
            findNavController().navigate(R.id.action_mpinFragment_to_loginFragment)
        })

        binding.mpinET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.length == AppConstants.PIN_LENGTH) {
                    //user_entered_pin = edt.getText() + "";
                    var pinStr = s.toString().trim()
                    pinStr = EncryptUtil.get_SHA_512_SecurePassword(pinStr)
                    if (pinStr == mpin) {
                        //MainActivity.FROM_PINCHECK=1;
                        launchHomeActivity()

                    } else {
                        Toast.makeText(
                            requireContext(),
                            R.string.wrong_mpin,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })

    }

    fun launchHomeActivity() {
        val intent = Intent(activity, NewHomeActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
    }


}