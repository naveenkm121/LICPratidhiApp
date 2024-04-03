package com.ecommerce.app.data.cart

data class CartData(
    val cartItems: List<CartItem>,
    val totalDiscountPrice: Double,
    val totalPrice: Double,
    val totalProducts: Int,
    val totalQuantity: Int
)