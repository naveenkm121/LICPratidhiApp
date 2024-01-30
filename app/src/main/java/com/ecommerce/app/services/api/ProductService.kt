package com.ecommerce.app.services.api

import com.ecommerce.app.constants.Constants
import com.ecommerce.app.data.PokemonRes
import com.ecommerce.app.data.product.ProductRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProductService {

    @GET("${Constants.BASE_URL}${Constants.END_POINT_POKEMONS}")
    suspend fun getPokemons(): Response<PokemonRes>

   // @GET("/products")
    //@GET("${Constants.BASE_URL}/products")
   @GET("/products")
    suspend fun  getProducts():Response<ProductRes>
   // suspend fun  getProducts(@Query("page") String page):Response<ProductRes>
}