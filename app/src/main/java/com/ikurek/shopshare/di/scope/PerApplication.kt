package com.ikurek.shopshare.di.scope

import javax.inject.Qualifier

/**
 * This annotation alows instatniating object
 * Only once app-wide
 * Is this a bad, sick hack? I don't know :-(
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PerApplication