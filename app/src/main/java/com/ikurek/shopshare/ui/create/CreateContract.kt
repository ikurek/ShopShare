package com.ikurek.shopshare.ui.create

import com.ikurek.shopshare.base.BaseContract
import com.ikurek.shopshare.model.Product

class CreateContract {

    interface View : BaseContract.View {
        fun updateQuantityText(quantity: String)
        fun readProduct(): Product
    }

    interface Presenter : BaseContract.Presenter<CreateContract.View> {
        fun handlePlusButton()
        fun handleMinusButton()
        fun handleSaveButton()
    }
}