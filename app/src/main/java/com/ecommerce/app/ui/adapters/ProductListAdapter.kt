package com.ecommerce.app.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.app.R
import com.ecommerce.app.data.product.ProductItem

class ProductListAdapter(private val context: Context) : RecyclerView.Adapter<ProductListAdapter.ProductVH>() {


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
        val product: ProductItem = items.get(position)

        holder.productBrandTV.text=product.brand
        holder.productNameTV.text=product.title
        Glide.with(context)
            .load(product.thumbnail)
            .into(holder.productImageView)


    }



    class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
        val productBrandTV: TextView
        val productNameTV:TextView
        val productImageView:ImageView



        init {
            productImageView=view.findViewById(R.id.productImageView)
            productBrandTV = view.findViewById(R.id.productBrandTV)
            productNameTV=view.findViewById(R.id.productNameTV)
        }
    }

}