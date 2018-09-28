package com.ikurek.shopshare.di.component

import com.ikurek.shopshare.di.module.FirebaseHelperModule
import com.ikurek.shopshare.ui.create.CreatePresenter
import com.ikurek.shopshare.ui.list.ListPresenter
import dagger.Component

/**
 * Dagger component for Application
 * Allows injecting BaseApp
 */
@Component(modules = arrayOf(FirebaseHelperModule::class))
interface FirebaseHelperComponent {

    fun inject(createPresenter: CreatePresenter)

    fun inject(listPresenter: ListPresenter)

}