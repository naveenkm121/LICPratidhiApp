package com.ecommerce.app.services.api

import com.ecommerce.app.data.product.ProductDetailRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @POST("auth/login")
    suspend fun getProductDetailsById(@Path("prodId") prodId: Int): Response<ProductDetailRes>
}