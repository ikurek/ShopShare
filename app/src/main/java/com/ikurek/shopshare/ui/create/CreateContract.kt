package com.ikurek.shopshare.ui.create

import com.ikurek.shopshare.base.BaseContract

class CreateContract {

    interface View : BaseContract.View {
        fun updateQuantityText(quantity: String)
    }

    interface Presenter : BaseContract.Presenter<CreateContract.View> {
        fun handlePlusButton()
        fun handleMinusButton()
    }
}