package com.ecommerce.app.data.wishlist

data class WishlistItem(
    val brand: String,
    val discount_per: Double,
    val id: Int,
    val price: Int,
    val prodId: Int,
    val thumbnail: String,
    val title: String
)