package com.ecommerce.app.data.category

data class Category(
    val id: Int,
    val name: String,
    val subCategories: List<SubCategory>
)