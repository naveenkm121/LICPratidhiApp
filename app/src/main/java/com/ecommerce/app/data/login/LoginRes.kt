package com.ecommerce.app.data.login

data class LoginRes(
    val data: LoginData,
    val message: String,
    val status: Int,
    val token: String
)