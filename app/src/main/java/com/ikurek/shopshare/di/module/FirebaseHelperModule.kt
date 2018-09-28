package com.ikurek.shopshare.di.module

import com.ikurek.shopshare.database.FirebaseHelper
import dagger.Module
import dagger.Provides

/**
 * Provides dependency for application
 */

@Module
class FirebaseHelperModule {

    @Provides
    fun provideFirebaseHelper(): FirebaseHelper {
        return FirebaseHelper()
    }
}