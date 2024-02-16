package com.ecommerce.app.data.product

data class ProductItem(
    var brand: String="",
    val category: Category?,
    val description: String="",
    val discountPercentage: Double=0.0,
    var id: Int=0,
    val images: List<ProductImage>,
    val price: Double=0.0,
    val rating: Double=0.0,
    val stock: Int=0,
    val subCategory: SubCategory?,
    val subSubCategory: SubSubCategory?,
    val thumbnail: String="",
    var title: String=""
)