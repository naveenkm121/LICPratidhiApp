package com.ecommerce.app.data.category

data class SubCategory(
    val catId: Int,
    val id: Int,
    val name: String,
    val subSubCategories: List<SubSubCategory>
)