package com.ikurek.shopshare.ui.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ikurek.shopshare.R
import com.ikurek.shopshare.di.component.DaggerFragmentComponent
import com.ikurek.shopshare.di.module.FragmentModule
import com.ikurek.shopshare.model.Product
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject


class ListFragment : Fragment(), ListContract.View {

    companion object {
        const val TAG = "ListFragment"
    }

    @Inject
    lateinit var presenter: ListContract.Presenter
    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
    }

    override fun showList(listOfProducts: List<Product>) {
        adapter = ListAdapter(listOfProducts)
        fragment_list_recyclerview.layoutManager = LinearLayoutManager(this.context)
        fragment_list_recyclerview.adapter = adapter
        fragment_list_recyclerview.setHasFixedSize(true)
    }

    override fun updateList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun injectDependency() {
        DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()
                .inject(this)
    }


}
