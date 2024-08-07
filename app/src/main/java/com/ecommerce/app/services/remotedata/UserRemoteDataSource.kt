package com.ecommerce.app.services.remotedata

import com.ecommerce.app.constants.RequestApiType
import com.ecommerce.app.data.address.AddressReq
import com.ecommerce.app.data.cart.CartItem
import com.ecommerce.app.data.cart.CartReq
import com.ecommerce.app.data.login.LoginReq
import com.ecommerce.app.data.login.SignupReq
import com.ecommerce.app.services.api.UserService
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val userService: UserService): BaseDataSource() {

    suspend fun getLogin( loginReq: LoginReq)=getResult ({ userService.getLogin(loginReq) },RequestApiType.REQUEST_LOGIN.value)

    suspend fun getSignup( signupReq: SignupReq)=getResult ({ userService.getSignup(signupReq) },RequestApiType.REQUEST_SIGNUP.value)

    suspend fun getWishlist( )=getResult( { userService.getWishlist() },RequestApiType.REQUEST_WISHLIST.value)

    suspend fun getAddressList( )=getResult ({ userService.getAddressList() },RequestApiType.REQUEST_GET_ADDRESS_LIST.value)

    suspend fun addAddress(addressReq: AddressReq)=getResult ({ userService.addAddress(addressReq) },RequestApiType.REQUEST_ADD_ADDRESS.value)

    suspend fun updateAddress(id: Int,addressReq: AddressReq)=getResult( { userService.updateAddress(id,addressReq) },RequestApiType.REQUEST_UPDATE_ADDRESS.value)

    suspend fun deleteAddress(id: Int)=getResult ({ userService.deleteAddress(id) },RequestApiType.REQUEST_DELETE_ADDRESS.value)

    suspend fun getPincodeDetails(pincode:String )=getResult ({ userService.getPincodeDetails(pincode) },RequestApiType.REQUEST_GET_PINCODE_DETAILS.value)

    suspend fun getCartItems( )=getResult ({ userService.getCartItems() },RequestApiType.REQUEST_GET_CART_ITEMS.value)

    suspend fun deleteCartItem(id: Int)=getResult ({ userService.deleteCartItem(id) },RequestApiType.REQUEST_DELETE_CART_ITEM.value)

    suspend fun addToCart(cartReq: CartReq)=getResult ({ userService.addToCart(cartReq) },RequestApiType.REQUEST_ADD_TO_CART.value)

    suspend fun updateCart(id: Int,cartItem: CartItem)=getResult ({ userService.updateCart(id,cartItem) },RequestApiType.REQUEST_UPDATE_CART.value)
}