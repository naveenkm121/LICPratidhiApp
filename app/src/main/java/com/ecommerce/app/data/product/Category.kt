package com.ecommerce.app.data.product

data class Category(
    val id: Int,
    val name: String,
    val subCategories: List<SubCategory>
)