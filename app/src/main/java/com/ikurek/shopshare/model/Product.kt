package com.ikurek.shopshare.model

/**
 * A boilerplate entity
 */
data class Product(var ammount: Long, var name: String, var notes: String) {

    // Empty constructor required by firebase
    constructor() : this(0, "", "")
}