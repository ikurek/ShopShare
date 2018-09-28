package com.ikurek.shopshare.ui.create


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ikurek.shopshare.R
import com.ikurek.shopshare.di.component.DaggerFragmentComponent
import com.ikurek.shopshare.di.module.FragmentModule
import com.ikurek.shopshare.model.Product
import kotlinx.android.synthetic.main.fragment_create.*
import javax.inject.Inject

class CreateFragment : Fragment(), CreateContract.View {

    companion object {
        const val TAG = "CreateFragment"
    }

    @Inject
    lateinit var presenter: CreateContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        bindUiHandlers()
    }

    override fun updateQuantityText(quantity: String) {
        fragment_create_quantity.text = quantity
    }

    //FIXME: Add validation, etc.
    override fun readProduct(): Product {
        return Product(
                fragment_create_quantity.text.toString().toLong(),
                fragment_create_product_text_input.text.toString(),
                ""
        )
    }

    private fun injectDependency() {
        val createComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()

        createComponent.inject(this)
    }

    private fun bindUiHandlers() {
        fragment_create_plus_button.setOnClickListener { presenter.handlePlusButton() }
        fragment_create_minus_button.setOnClickListener { presenter.handleMinusButton() }
        fragment_create_save_button.setOnClickListener { presenter.handleSaveButton() }
    }

}
