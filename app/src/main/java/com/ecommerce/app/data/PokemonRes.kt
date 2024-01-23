package com.ecommerce.app.data

data class PokemonRes(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)