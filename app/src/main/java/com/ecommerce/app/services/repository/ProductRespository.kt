package com.ecommerce.app.services.repository

import com.ecommerce.app.services.remotedata.ProductRemoteDataSource
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
}