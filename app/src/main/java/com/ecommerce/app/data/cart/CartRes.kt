package com.ecommerce.app.data.cart

data class CartRes(
    val `data`: CartData,
    val message: String,
    val status: Int
)