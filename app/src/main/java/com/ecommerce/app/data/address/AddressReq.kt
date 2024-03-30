package com.ecommerce.app.data.address

data class AddressReq(
    var name: String="",
    var mobile: String="",
    var address1: String="",
    var address2: String="",
    var landmark: String="",
    var locality: String="",
    var pincode: String="",
    var city: String="",
    var state: String="",
    var isDefault:Int=0

)