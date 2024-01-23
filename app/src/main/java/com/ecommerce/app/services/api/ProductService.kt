package com.ecommerce.app.services.api

import com.ecommerce.app.constants.Constants
import com.ecommerce.app.data.PokemonRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductService {

    @GET("${Constants.BASE_URL}${Constants.END_POINT_POKEMONS}")
    suspend fun getPokemons(): Response<PokemonRes>
}