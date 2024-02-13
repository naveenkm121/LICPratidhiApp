package com.ecommerce.app.data.filter

data class FilterItem(
    val id: Int,
    val max_price: Int,
    val min_price: Int,
    val name: String,
    val value: String,
    var isSelected:Boolean
)