package com.ikurek.shopshare.ui.main

class MainPresenter: MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun onFabClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}