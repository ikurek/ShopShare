package com.ikurek.shopshare.base

import android.app.Application
import com.ikurek.shopshare.di.component.ApplicationComponent
import com.ikurek.shopshare.di.component.DaggerApplicationComponent
import com.ikurek.shopshare.di.module.ApplicationModule

/**
 * Base Application class with Dagger support
 */
class BaseApp: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        // Initialize BaseApp as instance of Application
        instance = this
        setup()

    }

    /**
     * Creates DaggerApplicationComponent
     * And injects BaseApp instance as application
     */
    fun setup() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        component.inject(this)
    }

    /**
     * Returns ApplicationComponent
     */
    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    /**
     * Companion object with easy accessible instance of BaseApp
     */
    companion object {
        lateinit var instance: BaseApp private set
    }
}