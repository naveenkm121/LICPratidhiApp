package com.ecommerce.app.services.api

import com.ecommerce.app.data.address.AddressRes
import com.ecommerce.app.data.address.PincodeRes
import com.ecommerce.app.data.login.LoginReq
import com.ecommerce.app.data.login.LoginRes
import com.ecommerce.app.data.login.SignupReq
import com.ecommerce.app.data.wishlist.WishlistRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {

    @POST("auth/login")
    suspend fun getLogin(@Body request: LoginReq): Response<LoginRes>

    @POST("auth/signup")
    suspend fun getSignup(@Body request: SignupReq): Response<LoginRes>

    @GET("wishlist")
    suspend fun getWishlist(): Response<WishlistRes>

    @GET("address")
    suspend fun getAddressList(): Response<AddressRes>

    @GET("pincode/{pincode}")
    suspend fun getPincodeDetails(@Path("pincode") pincode:String): Response<PincodeRes>


}