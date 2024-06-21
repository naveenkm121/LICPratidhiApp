package com.ecommerce.app.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.data.address.AddressDataRes
import com.ecommerce.app.data.address.AddressReq
import com.ecommerce.app.data.cart.CartReq
import com.ecommerce.app.data.cart.CartRes
import com.ecommerce.app.services.repository.UserRepository
import com.ecommerce.app.utils.DebugHandler
import com.ecommerce.app.utils.ResourceViewState
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class CartViewModel @Inject constructor(private val userRepository: UserRepository):ViewModel() {

    private var cartId:Int=0
    private var requestType: String = ""
    private val _request = MutableLiveData<String>()
    private val _request_cart = MutableLiveData<CartReq>()

    private val _response = _request.switchMap {
        when(requestType)
        {
            ScreenName.REQUEST_CART_LIST.value->{
                userRepository.getCartItems()
            }

            ScreenName.REQUEST_DELETE_CART_ITEM.value->{
                userRepository.deleteCartItem(cartId)
            }
            else -> throw AssertionError()
        }


    }

    private val _response_data_cart = _request_cart.switchMap { request->

                userRepository.addToCart(request)

    }


    val response: LiveData<ResourceViewState<CartRes>> = _response
    val responseAddToCart: LiveData<ResourceViewState<CartRes>> = _response_data_cart

    fun getCartItems(requestType:String,request: String) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        this.requestType=requestType
        _request.value = request
    }

    fun deleteCartItem(requestType:String,cartId: Int) {
       // val req: String = Gson().toJson(request)
       // DebugHandler.log("CommonReq ::  $req")
        this.requestType=requestType
        this.cartId=cartId
        _request.value = cartId.toString()
    }

    fun addToCartItems(request: CartReq) {
        val req: String = Gson().toJson(request)
        DebugHandler.log("CommonReq ::  $req")
        _request_cart.value = request
    }

}