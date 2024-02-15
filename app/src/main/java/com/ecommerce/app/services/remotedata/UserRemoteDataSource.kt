package com.ecommerce.app.services.remotedata

import com.ecommerce.app.data.login.LoginReq
import com.ecommerce.app.services.api.UserService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val userService: UserService): BaseDataSource() {

    suspend fun getLogin( loginReq: LoginReq)=getResult { userService.getLogin(loginReq) }

    suspend fun getWishlist( )=getResult { userService.getWishlist() }
}