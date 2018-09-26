package com.ikurek.shopshare.ui.list

class ListPresenter : ListContract.Presenter {

    private lateinit var view: ListContract.View

    override fun attach(view: ListContract.View) {
        this.view = view
    }

}