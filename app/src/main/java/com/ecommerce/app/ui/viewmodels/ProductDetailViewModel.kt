package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.data.CommonReq
import com.ecommerce.app.data.product.ProductDetailRes
import com.ecommerce.app.data.product.ProductRes
import com.ecommerce.app.services.remotedata.ProductRemoteDataSource
import com.ecommerce.app.services.repository.ProductRespository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(private val productRespository: ProductRespository):ViewModel(){

    private var prodId:Int = 0
   // val response = productRemoteDataSource.getProductDetailsById(prodId)

    fun getProductDetailsById(prodId:Int){
        this.prodId=prodId
    }

    val response: LiveData<ResourceViewState<ProductDetailRes>> =  productRespository.getProductDetailsById(prodId = prodId)





  /*  private val _request = MutableLiveData<CommonReq?>()

    private val _response = _request.switchMap {
        productRespository.getProducts()

    }
    val response: LiveData<ResourceViewState<ProductRes>> = _response

    fun getProducts(request: CommonReq?) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request.value = request

    }*/
}