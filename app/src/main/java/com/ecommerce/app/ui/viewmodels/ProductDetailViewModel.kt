package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.product.ProductDetailRes
import com.ecommerce.app.data.product.ProductRes
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProductDetailViewModel @Inject constructor(private val productRespository: ProductRespository):ViewModel(){

    private var _prodId:Int = 1
    private val _request = MutableLiveData<Int>()

    fun getProductDetailsById(prodId:Int){
        _request.value=prodId
        _prodId=prodId
        DebugHandler.log("Hello getProduct")

    }
    private val _response = _request.switchMap {
        //productRespository.getProducts()
        productRespository.getProductDetailsById(prodId =_prodId)

    }

    val response: LiveData<ResourceViewState<ProductDetailRes>> = _response
    // val response = productRemoteDataSource.getProductDetailsById(prodId)



   // val response: LiveData<ResourceViewState<ProductDetailRes>> =  productRespository.getProductDetailsById(prodId = _prodId)

}