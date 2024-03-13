package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.paging.PagingData
import com.ecommerce.app.data.address.AddressRes
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.data.product.ProductReqParam
import com.ecommerce.app.data.wishlist.WishlistRes
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddressViewModel @Inject constructor(private val userRepository: UserRepository):
    ViewModel() {

    //  val list = userRepository.getWishList().cachedIn(viewModelScope)

    private val _request = MutableLiveData<String>()

    private val _response = _request.switchMap { request->
        userRepository.getAddressList()

    }
    val response: LiveData<ResourceViewState<AddressRes>> = _response

    fun getAddress(request: String?) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request!!

    }


}