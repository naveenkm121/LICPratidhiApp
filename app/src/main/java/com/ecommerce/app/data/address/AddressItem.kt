package com.ecommerce.app.data.address

data class AddressItem(
    val city: String,
    val id: Int,
    val isDefault: Int,
    val mobile: String,
    val name: String,
    val pincode: String,
    val state: String,
    var address1: String,
    var address2: String,
    val userId: Int
)