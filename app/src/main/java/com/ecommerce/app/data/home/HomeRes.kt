package com.ecommerce.app.data.home

data class HomeRes(
    val views: List<ViewType>,
    val message: String,
    val status: Int
)