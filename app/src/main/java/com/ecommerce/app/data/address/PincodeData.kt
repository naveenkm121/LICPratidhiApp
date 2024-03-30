package com.ecommerce.app.data.address

data class PincodeData(
    val district: String,
    val locality: List<String>,
    val pincode: String,
    val state: String
)