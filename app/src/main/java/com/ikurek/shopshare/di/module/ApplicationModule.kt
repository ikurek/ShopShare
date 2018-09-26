package com.ikurek.shopshare.di.module

import android.app.Application
import com.ikurek.shopshare.base.BaseApp
import com.ikurek.shopshare.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Provides dependency for application
 */

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }
}