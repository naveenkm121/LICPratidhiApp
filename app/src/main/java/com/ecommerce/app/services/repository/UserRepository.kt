package com.ecommerce.app.services.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ecommerce.app.data.login.LoginReq
import com.ecommerce.app.data.login.SignupReq
import com.ecommerce.app.services.api.ProductService
import com.ecommerce.app.services.remotedata.UserRemoteDataSource
import com.ecommerce.app.ui.paging.ProductPagingSource
import com.ecommerce.app.utils.performGetOperation
import javax.inject.Inject


class UserRepository @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) {

/*    fun getProductList() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 100),
        pagingSourceFactory = { ProductPagingSource(productService) }
    ).liveData*/

    fun getLogin(loginReq: LoginReq) = performGetOperation(
        networkCall = { userRemoteDataSource.getLogin(loginReq) }
    )

    fun getSignup(signupReq: SignupReq) = performGetOperation(
        networkCall = { userRemoteDataSource.getSignup(signupReq) }
    )

    fun getWishlist() = performGetOperation(
        networkCall = { userRemoteDataSource.getWishlist() }
    )

    fun getAddressList() = performGetOperation(
        networkCall = { userRemoteDataSource.getAddressList() }
    )

    fun getPincodeDetails(pincode:String) = performGetOperation(
        networkCall = { userRemoteDataSource.getPincodeDetails(pincode) }
    )

}