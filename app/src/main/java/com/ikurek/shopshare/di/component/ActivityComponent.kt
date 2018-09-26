package com.ikurek.shopshare.di.component

import com.ikurek.shopshare.di.module.ActivityModule
import com.ikurek.shopshare.ui.main.MainActivity
import dagger.Component

/**
 * Dagger component for MainActivity
 * Allows injecting MainActivity
 */

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}