package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.paging.PagingData
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.data.product.ProductReqParam
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val productRespository: ProductRespository):ViewModel() {

  //  val list = userRepository.getWishList().cachedIn(viewModelScope)

    private val _request = MutableLiveData<ProductReqParam>()

    private val _response = _request.switchMap { request->
        productRespository.getProductList(request)

    }
    val response: LiveData<PagingData<ProductItem>> = _response

    fun getProducts(request: ProductReqParam?) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request!!

    }


}