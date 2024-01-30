package com.ecommerce.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.R
import com.ecommerce.app.data.product.ProductItem

class ProductListAdapter : RecyclerView.Adapter<ProductListAdapter.ProductVH>() {


    private val items = ArrayList<ProductItem>()

    fun setItems(items: ArrayList<ProductItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int= items.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductVH {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_product, viewGroup, false)

        return ProductVH(view)
    }
    override fun onBindViewHolder(holder: ProductVH, position: Int) {

    }



    class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
       // val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
           // textView = view.findViewById(R.id.textView)
        }
    }

}