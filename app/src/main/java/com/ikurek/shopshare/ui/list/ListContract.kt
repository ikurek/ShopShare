package com.ikurek.shopshare.ui.list

import com.ikurek.shopshare.base.BaseContract

class ListContract {

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<ListContract.View>
}