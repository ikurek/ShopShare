package com.ikurek.shopshare.ui.create

import android.util.Log
import com.ikurek.shopshare.database.FirebaseHelper
import com.ikurek.shopshare.di.component.DaggerFirebaseHelperComponent
import com.ikurek.shopshare.di.module.FirebaseHelperModule
import javax.inject.Inject

class CreatePresenter : CreateContract.Presenter {

    @Inject
    lateinit var firebaseHelper: FirebaseHelper

    private lateinit var view: CreateContract.View
    private var quantity: Int = 1

    override fun attach(view: CreateContract.View) {
        this.view = view
        injectDependency()
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

    override fun handleSaveButton() {
        val product = view.readProduct()
        firebaseHelper.putProduct(product, {
            Log.d("CreatePresenter", "Success")
        }, {
            Log.d("CreatePresenter", "Failure")

        })

        firebaseHelper.getProducts({
            Log.d("CreatePresenter", "Products: ${it.size}")
        }, {
            Log.d("CreatePresenter", "Products: error")
        })
    }

    private fun injectDependency() {
        DaggerFirebaseHelperComponent.builder()
                .firebaseHelperModule(FirebaseHelperModule())
                .build()
                .inject(this)
    }
}