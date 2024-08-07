package com.ecommerce.app.constants

enum class RequestApiType (val value: String){

    REQUEST_LAUNCH_STATUS("RequestLaunchStatus"),
    REQUEST_LOGIN("RequestLogin"),
    REQUEST_SIGNUP("RequestSignup"),

    //Address Related
    REQUEST_GET_ADDRESS_LIST("RequestGetAddressList"),
    REQUEST_ADD_ADDRESS("RequestAddAddress"),
    REQUEST_UPDATE_ADDRESS("RequestUpdateAddress"),
    REQUEST_DELETE_ADDRESS("RequestDeleteAddress"),
    REQUEST_GET_PINCODE_DETAILS("RequestGetPincode"),

    //Cart Related
    REQUEST_GET_CART_ITEMS("RequestGetCartItems"),
    REQUEST_ADD_TO_CART("RequestAddToCart"),
    REQUEST_UPDATE_CART("RequestUpdateCart"),
    REQUEST_DELETE_CART_ITEM("RequestDeleteCartItem"),


    //Product Related
    REQUEST_GET_PRODUCTS("RequestGetProducts"),
    REQUEST_GET_PRODUCT_DETAILS("RequestGetProductDetails"),
    REQUEST_GET_CATEGORIES("RequestGetCategories"),
    REQUEST_WISHLIST("RequestWishlist"),





}