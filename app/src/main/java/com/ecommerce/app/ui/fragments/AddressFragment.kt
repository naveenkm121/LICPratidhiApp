package com.ecommerce.app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ecommerce.app.R
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.databinding.FragmentAddressBinding
import com.ecommerce.app.databinding.FragmentCategoryBinding
import com.ecommerce.app.databinding.FragmentWishlistBinding
import com.ecommerce.app.ui.viewmodels.AddressViewModel
import com.ecommerce.app.ui.viewmodels.CategoryViewModel
import com.ecommerce.app.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddressFragment : Fragment() {
    private var binding: FragmentAddressBinding by autoCleared()
    private val viewModel: AddressViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAddress(ScreenName.FRAGMENT_CATEGORY.value)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddressBinding.inflate(inflater, container, false)
        return binding.root
    }

}