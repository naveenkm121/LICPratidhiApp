package com.licapps.bmmis.data.model

class WishTag {

    var id: Int = 0
    var value: String? = null
    var isSelected = false

    constructor() {}
    constructor(id: Int, value: String?) {
        this.id = id
        this.value = value
    }

    constructor(id: Int, value: String?, isSelected: Boolean) {
        this.id = id
        this.value = value
        this.isSelected = isSelected
    }
}


