package com.ikurek.shopshare.ui.list

import com.ikurek.shopshare.database.FirebaseHelper
import com.ikurek.shopshare.di.component.DaggerFirebaseHelperComponent
import com.ikurek.shopshare.di.module.FirebaseHelperModule
import com.ikurek.shopshare.model.Product
import javax.inject.Inject

class ListPresenter : ListContract.Presenter {

    @Inject
    lateinit var firebaseHelper: FirebaseHelper
    private lateinit var view: ListContract.View
    private lateinit var listOfProducts: List<Product>

    override fun attach(view: ListContract.View) {
        this.view = view
        injectDependency()
        loadData()
    }

    override fun loadData() {
        firebaseHelper.getProducts({ listOfProducts ->
            this.listOfProducts = listOfProducts
            view.showList(listOfProducts)
        }, {
            //FIXME: Handle error
        })
    }

    private fun injectDependency() {
        DaggerFirebaseHelperComponent.builder()
                .firebaseHelperModule(FirebaseHelperModule())
                .build()
                .inject(this)
    }
}