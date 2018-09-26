package com.ikurek.shopshare.base

/**
 * Base for Contract classes
 * Contains interfaces for both
 * presenters and views
 */

class BaseContract {

    interface Presenter<in T> {
        fun attach(view: T)
    }

    interface View
}