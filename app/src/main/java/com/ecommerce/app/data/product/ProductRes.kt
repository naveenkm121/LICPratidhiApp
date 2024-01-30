package com.ecommerce.app.data.product

data class ProductRes(
    val data: List<ProductItem>,
    val isLast: Boolean,
    val message: String,
    val pageNo: Int,
    val pageSize: Int,
    val status: Int,
    val totalElements: Int,
    val totalPages: Int
)