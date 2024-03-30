package com.ecommerce.app.data.address

data class AddressItem(

    val id: Int,
    val isDefault: Int,
    val mobile: String,
    val name: String,
    val pincode: String,
    val city: String,
    val state: String,
    var address1: String,
    var address2: String,
    val locality: String,
    val landmark: String,
    val userId: Int
)