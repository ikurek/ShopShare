package com.ikurek.shopshare.ui.create

class CreatePresenter : CreateContract.Presenter {

    private lateinit var view: CreateContract.View
    private var quantity: Int = 1

    override fun attach(view: CreateContract.View) {
        this.view = view
    }

    override fun handlePlusButton() {
        quantity++
        view.updateQuantityText(quantity.toString())
    }

    override fun handleMinusButton() {
        if (quantity > 1) {
            quantity--
            view.updateQuantityText(quantity.toString())
        }
    }
}