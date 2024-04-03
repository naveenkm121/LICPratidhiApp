package com.ecommerce.app.data.cart

data class CartItem(
    val brand: String,
    val discountPrice: Double,
    val discount_per: Double,
    val id: Int,
    val price: Double,
    val prodId: Int,
    val quantity: Int,
    val thumbnail: String,
    val title: String,
    val totalDiscountPrice: Double,
    val totalPrice: Double
)