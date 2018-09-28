package com.ikurek.shopshare.ui.list

import com.ikurek.shopshare.base.BaseContract
import com.ikurek.shopshare.model.Product

class ListContract {

    interface View : BaseContract.View {
        fun showList(listOfProducts: List<Product>)
        fun updateList()
    }

    interface Presenter : BaseContract.Presenter<ListContract.View> {
        fun loadData()
    }
}