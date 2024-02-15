package com.ecommerce.app.data.wishlist

data class WishlistRes(
    val `data`: List<WishlistItem>,
    val message: String,
    val status: Int
)