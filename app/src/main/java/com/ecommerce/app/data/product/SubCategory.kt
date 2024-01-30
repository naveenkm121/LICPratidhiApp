package com.ecommerce.app.data.product

data class SubCategory(
    val catId: Int,
    val id: Int,
    val name: String,
    val subSubCategories: List<SubSubCategory>
)