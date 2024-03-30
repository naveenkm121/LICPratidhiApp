package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.wishlist.WishlistRes
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddAddressViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {


    private val _request = MutableLiveData<CommonReq?>()

    private val _response = _request.switchMap {
        userRepository.getWishlist()

    }
    val response: LiveData<ResourceViewState<WishlistRes>> = _response

    fun getWishlist(request: CommonReq?) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }

    // val list = productRespository.getProducts().cachedIn(viewModelScope)


    // val response: LiveData<PagingData<ProductItem>> =  productRespository.getProducts().cachedIn(viewModelScope)

}