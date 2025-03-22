package com.licapps.bmmis.data.model.login

data class LoginRes(
    var message: String = "",
    var status: Int = 0,
    var token: String = "",
    var data: LoginData = LoginData()
)