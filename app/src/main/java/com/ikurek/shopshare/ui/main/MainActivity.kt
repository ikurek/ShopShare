package com.ikurek.shopshare.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ikurek.shopshare.R
import com.ikurek.shopshare.di.component.DaggerActivityComponent
import com.ikurek.shopshare.di.module.ActivityModule
import com.ikurek.shopshare.ui.create.CreateFragment
import com.ikurek.shopshare.ui.list.ListFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        injectDependency()
        presenter.attach(this)
        bindUiHandlers()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.findFragmentByTag(ListFragment.TAG)?.let { listFragment ->
            if (listFragment.isVisible) showFab()
            else hideFab()
        }
    }

    override fun showListFragment() {
        supportFragmentManager.beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.activity_main_frame, ListFragment(), ListFragment.TAG)
                .commit()
    }

    override fun showCreateFragment() {
        supportFragmentManager.beginTransaction()
                .addToBackStack(CreateFragment.TAG)
                .replace(R.id.activity_main_frame, CreateFragment(), CreateFragment.TAG)
                .commit()
    }

    override fun hideFab() {
        if (activity_main_fab.isOrWillBeShown) {
            activity_main_fab.hide()
        }
    }

    override fun showFab() {
        if (activity_main_fab.isOrWillBeHidden) {
            activity_main_fab.show()
        }
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .build()

        activityComponent.inject(this)
    }

    private fun bindUiHandlers() {
        activity_main_fab.setOnClickListener { presenter.handleFabClick() }
    }

}
