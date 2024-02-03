package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.product.ProductRes
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProductListViewModel @Inject constructor(private val productRespository: ProductRespository):ViewModel() {


    private val _request = MutableLiveData<CommonReq?>()

    private val _response = _request.switchMap {
        productRespository.getProducts()

    }
    val response: LiveData<ResourceViewState<ProductRes>> = _response

    fun getProducts(request: CommonReq?) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }

   // val list = productRespository.getProducts().cachedIn(viewModelScope)


   // val response: LiveData<PagingData<ProductItem>> =  productRespository.getProducts().cachedIn(viewModelScope)
}