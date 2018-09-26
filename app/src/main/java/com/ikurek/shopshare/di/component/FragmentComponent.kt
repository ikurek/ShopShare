package com.ikurek.shopshare.di.component

import com.ikurek.shopshare.di.module.FragmentModule
import com.ikurek.shopshare.ui.create.CreateFragment
import com.ikurek.shopshare.ui.list.ListFragment
import dagger.Component

/**
 * Dagger component for Fragment
 * Allows injecting Fragments
 */
@Component(modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(listFragment: ListFragment)

    fun inject(createFragment: CreateFragment)

}