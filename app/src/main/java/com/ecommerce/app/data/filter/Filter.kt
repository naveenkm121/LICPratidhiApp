package com.ecommerce.app.data.filter

data class Filter(
    val filterItems: List<FilterItem>,
    val filterName: String,
    val filterType: String,
    val id: Int,
    var isSelected:Boolean
)