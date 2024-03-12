package com.ecommerce.app.data.address

data class AddressRes(
    val `data`: List<AddressItem>,
    val message: String,
    val status: Int
)