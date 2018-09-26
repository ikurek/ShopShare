package com.ikurek.shopshare.di.module

import com.ikurek.shopshare.ui.create.CreateContract
import com.ikurek.shopshare.ui.create.CreatePresenter
import com.ikurek.shopshare.ui.list.ListContract
import com.ikurek.shopshare.ui.list.ListPresenter
import dagger.Module
import dagger.Provides

/**
 * Provides dependencies for fragments
 */

@Module
class FragmentModule {

    @Provides
    fun provideListPresenter(): ListContract.Presenter {
        return ListPresenter()
    }

    @Provides
    fun provideCreatePresenter(): CreateContract.Presenter {
        return CreatePresenter()
    }

}