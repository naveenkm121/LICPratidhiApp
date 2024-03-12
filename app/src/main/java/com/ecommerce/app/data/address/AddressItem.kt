package com.ecommerce.app.data.address

data class AddressItem(
    val city: String,
    val country: String,
    val id: Int,
    val isDefault: Int,
    val mobile: String,
    val name: String,
    val pincode: String,
    val state: String,
    val street: String,
    val userId: Int
)