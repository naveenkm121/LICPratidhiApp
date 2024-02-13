package com.ecommerce.app.data.filter

data class FilterRes(
    val filters: List<Filter>,
    val message: String,
    val status: Int
)