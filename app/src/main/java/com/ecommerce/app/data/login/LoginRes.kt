package com.ecommerce.app.data.login

data class LoginRes(
    val data: UserData,
    val message: String,
    val status: Int,
    val token: String
)