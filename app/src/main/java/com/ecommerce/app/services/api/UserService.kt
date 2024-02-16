package com.ecommerce.app.services.api

import com.ecommerce.app.data.login.LoginReq
import com.ecommerce.app.data.login.LoginRes
import com.ecommerce.app.data.login.SignupReq
import com.ecommerce.app.data.wishlist.WishlistRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    @POST("auth/login")
    suspend fun getLogin(@Body request: LoginReq): Response<LoginRes>

    @POST("auth/signup")
    suspend fun getSignup(@Body request: SignupReq): Response<LoginRes>

    @GET("wishlist")
    suspend fun getWishlist(): Response<WishlistRes>


}