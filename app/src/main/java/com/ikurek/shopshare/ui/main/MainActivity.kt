package com.ikurek.shopshare.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ikurek.shopshare.R
import com.ikurek.shopshare.di.component.DaggerActivityComponent
import com.ikurek.shopshare.di.module.ActivityModule
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependency()
        presenter.attach(this)
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }

    override fun showListFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showCreateFragment() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
