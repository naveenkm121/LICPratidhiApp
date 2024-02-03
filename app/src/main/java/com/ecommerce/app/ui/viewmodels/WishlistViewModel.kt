package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.data.product.ProductRes
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {

  //  val list = userRepository.getWishList().cachedIn(viewModelScope)

    private val _request = MutableLiveData<CommonReq?>()

    private val _response = _request.switchMap {
        userRepository.getWishList()

    }
    val response: LiveData<PagingData<ProductItem>> = _response

    fun getProducts(request: CommonReq?) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }


}