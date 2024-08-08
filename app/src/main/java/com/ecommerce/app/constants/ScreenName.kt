package com.ecommerce.app.constants

enum class ScreenName (val value: String) {

    //Screens
    FRAGMENT_HOME_TOP_CATEGORY("FragmentHomeTopCategory"),
    FRAGMENT_CATEGORY("FragmentCategory"),
    FRAGMENT_ADDRESS("FragmentAddress"),
    FRAGMENT_CART("FragmentCart"),

    //Events
    ACTION_DELETE_ADDRESS("ActionDeleteAddress"),
    ACTION_EDIT_ADDRESS("ActionEditAddress"),
    ACTION_DEFAULT_ADDRESS("ActionDefaultAddress"),

    ACTION_DELETE_CART("ActionDeleteCart"),
    ACTION_MINUS_FROM_CART("ActionMinusFromCart"),
    ACTION_ADD_ITEM_TO_CART("ActionAddItemToCart"),



}
