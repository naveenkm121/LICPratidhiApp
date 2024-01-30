package com.ecommerce.app.data.product

data class ProductItem(
    val brand: String,
    val category: Category,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<Image>,
    val price: Double,
    val rating: Double,
    val stock: Int,
    val subCategory: SubCategory,
    val subSubCategory: SubSubCategory,
    val thumbnail: String,
    val title: String
)