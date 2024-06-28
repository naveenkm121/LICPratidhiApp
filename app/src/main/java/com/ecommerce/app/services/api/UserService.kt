package com.ecommerce.app.services.api

import com.ecommerce.app.data.address.AddressDataRes
import com.ecommerce.app.data.address.AddressReq
import com.ecommerce.app.data.address.AddressRes
import com.ecommerce.app.data.address.PincodeRes
import com.ecommerce.app.data.cart.CartItem
import com.ecommerce.app.data.cart.CartReq
import com.ecommerce.app.data.cart.CartRes
import com.ecommerce.app.data.login.LoginReq
import com.ecommerce.app.data.login.LoginRes
import com.ecommerce.app.data.login.SignupReq
import com.ecommerce.app.data.wishlist.WishlistRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
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

    @DELETE("address/{id}")
    suspend fun deleteAddress(@Path("id") id:Int): Response<AddressDataRes>

    @PUT("address/{id}")
    suspend fun updateAddress(@Path("id") id:Int,@Body addressReq: AddressReq): Response<AddressDataRes>

    @POST("address")
    suspend fun addAddress(@Body addressReq: AddressReq): Response<AddressDataRes>

    @GET("pincode/{pincode}")
    suspend fun getPincodeDetails(@Path("pincode") pincode:String): Response<PincodeRes>

    @GET("cart")
    suspend fun getCartItems(): Response<CartRes>

    @DELETE("cart/{id}")
    suspend fun deleteCartItem(@Path("id") id:Int): Response<CartRes>

    @POST("cart")
    suspend fun addToCart(@Body cartReq: CartReq): Response<CartRes>

    @PUT("cart/{id}")
    suspend fun updateCart(@Path("id") id:Int,@Body cartItem: CartItem): Response<CartRes>

}