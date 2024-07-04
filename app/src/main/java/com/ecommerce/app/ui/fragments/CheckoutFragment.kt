package com.ecommerce.app.ui.fragments

import android.content.DialogInterface
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecommerce.app.R
import com.ecommerce.app.R.color.black
import com.ecommerce.app.R.color.red
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.data.cart.CartData
import com.ecommerce.app.data.cart.CartItem
import com.ecommerce.app.databinding.FragmentCartBinding
import com.ecommerce.app.databinding.FragmentCheckoutBinding
import com.ecommerce.app.ui.activities.HomeActivity
import com.ecommerce.app.ui.adapters.CommonRVAdapter
import com.ecommerce.app.ui.viewmodels.CartViewModel
import com.ecommerce.app.utils.AlertDialogListener
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.CommonUtility
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.ecommerce.app.utils.UICommon
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CheckoutFragment : Fragment() {
    private var binding: FragmentCheckoutBinding by autoCleared()
    private val viewModel: CartViewModel by viewModels()
    private lateinit var adapter: CommonRVAdapter
    private var cartItemList = ArrayList<CartItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCheckoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.topProgressLyt.addressDotView.setBackgroundTintList(
            ColorStateList.valueOf(requireContext().getColor(
                red
            )))
        binding.topProgressLyt.addressLineView.setBackgroundColor(requireContext().getColor(red))
        binding.topProgressLyt.addressTV.setTextColor(requireContext().getColor(black))

        binding.topProgressLyt.checkoutDotView.setBackgroundTintList(
            ColorStateList.valueOf(requireContext().getColor(
                red
            )))
        binding.topProgressLyt.checkoutLineView.setBackgroundColor(requireContext().getColor(red))
        binding.topProgressLyt.checkoutTV.setTextColor(requireContext().getColor(black))
    }





}