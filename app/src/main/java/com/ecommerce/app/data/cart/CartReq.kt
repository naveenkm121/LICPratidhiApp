package com.ecommerce.app.data.cart

data class CartReq(
    var prodId: Long=0,
    var quantity: Int=0,
    var userId :Long=0
)