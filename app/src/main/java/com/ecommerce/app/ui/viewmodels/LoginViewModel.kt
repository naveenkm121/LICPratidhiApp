package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.data.product.ProductDetailRes
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.ResourceViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {



}