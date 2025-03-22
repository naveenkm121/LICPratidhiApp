package com.licapps.bmmis.constants


/*This file contains all base URLS and other endpoints*/
class Constants {
    companion object {
        val PDF: String = "PDF"


        //URLS
        const val BASE_URL_PROD: String = "https://microapigo.licindia.in/BMMISServicesAuth/"
        const val BASE_URL_UAT: String = "https://microapigo.licindia.in/BMMISServicesAuth/" //UAT is not used currently
        const val BASE_URL: String = BASE_URL_PROD
        //Encryption.java
        const val SALT = "@34sdcuje!sem_4"
    }
}