package com.ikurek.shopshare.di.component

import com.ikurek.shopshare.base.BaseApp
import com.ikurek.shopshare.di.module.ApplicationModule
import dagger.Component

/**
 * Dagger component for Application
 * Allows injecting BaseApp
 */
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)

}