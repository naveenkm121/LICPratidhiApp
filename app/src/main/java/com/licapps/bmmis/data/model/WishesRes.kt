package com.licapps.bmmis.data.model

data class WishesRes(
    val message: String="",
    val status: Int=0,
    val data:List<Wish> = listOf()
)