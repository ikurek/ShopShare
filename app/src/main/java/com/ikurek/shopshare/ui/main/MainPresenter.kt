package com.ikurek.shopshare.ui.main

class MainPresenter: MainContract.Presenter {

    private lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showFab()
        view.showListFragment()
    }

    override fun handleFabClick() {
        view.hideFab()
        view.showCreateFragment()
    }

}