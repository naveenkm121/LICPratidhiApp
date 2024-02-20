package com.ecommerce.app.data.category

data class CategoryRes(
    val `data`: List<Category>,
    val message: String,
    val status: Int
)