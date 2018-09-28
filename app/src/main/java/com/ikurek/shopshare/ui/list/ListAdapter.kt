package com.ikurek.shopshare.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ikurek.shopshare.R
import com.ikurek.shopshare.model.Product
import kotlinx.android.synthetic.main.list_item_product.view.*

class ListAdapter(var listOFProducts: List<Product>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    class ListViewHolder(val singleRowView: View) : RecyclerView.ViewHolder(singleRowView) {
        fun bind(product: Product) {
            singleRowView.list_item_product_name.text = product.name
            singleRowView.list_item_product_quantity.text = product.ammount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_product, parent, false)

        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOFProducts.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listOFProducts[position])
    }
}