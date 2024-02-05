package com.ecommerce.app.services.repository

import androidx.core.os.persistableBundleOf
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ecommerce.app.services.remotedata.ProductRemoteDataSource
import com.ecommerce.app.ui.paging.ProductPagingSource
import com.ecommerce.app.utils.performGetOperation
import javax.inject.Inject

class ProductRespository @Inject constructor(private  val  remoteDataSource: ProductRemoteDataSource) {

    fun getPokemons() = performGetOperation(
        networkCall = { remoteDataSource.getPokemons() }
    )

    fun getLaunchStatus() = performGetOperation(
        networkCall = { remoteDataSource.getLaunchStatus() }
    )

    fun getProducts() = performGetOperation(
        networkCall = { remoteDataSource.getProducts() }
    )

    fun getProductDetailsById(prodId:Int)= performGetOperation(
        networkCall = { remoteDataSource.getProductDetailsById(prodId) }
    )


  /*  fun getProducts(pageNo:Int) = performGetOperation(
        networkCall = { remoteDataSource.getProducts(pageNo) }
    )

   fun getProducts() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 100),
        pagingSourceFactory = { ProductPagingSource(this) }
   ).liveData*/


}