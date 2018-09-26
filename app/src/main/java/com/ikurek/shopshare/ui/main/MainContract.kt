package com.ikurek.shopshare.ui.main

import com.ikurek.shopshare.base.BaseContract

class MainContract {

    interface View: BaseContract.View {
        fun showListFragment()
        fun showCreateFragment()
        fun hideFab()
        fun showFab()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
        fun handleFabClick()
    }
}