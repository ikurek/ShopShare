package com.ikurek.shopshare.di.module

import android.app.Activity
import com.ikurek.shopshare.ui.main.MainContract
import com.ikurek.shopshare.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

/**
 * I only plan to use one Activity
 * Hence this only provides dependency for MainActivity and MainPresenter
 */

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

}