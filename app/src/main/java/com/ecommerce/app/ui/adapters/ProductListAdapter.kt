package com.ecommerce.app.ui.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.app.R
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.utils.DebugHandler


class ProductListAdapter(private val context: Context,private val listener: CardItemListener) : RecyclerView.Adapter<ProductListAdapter.ProductVH>() {


    private val items = ArrayList<ProductItem>()


    interface CardItemListener {
        fun onClickedCard(productItem: ProductItem)
    }

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
        //holder.discountPriceTV.text= "$${product.price}"
        //holder.priceTV.text= "$${product.price}"
        holder.discountPriceTV.text=context.getString(R.string.input_rs_symbol,product.price.toString())
        holder.priceTV.text=context.getString(R.string.input_rs_symbol,product.price.toString())
        holder.discountTV.text="${product.discountPercentage}%"
        holder.priceTV.setPaintFlags(holder.priceTV.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
      /*  Glide.with(context)
            .load(product.thumbnail)
            .into(holder.productImageView)*/
        holder.itemView.setOnClickListener {
            listener.onClickedCard(product)
        }


    }



    class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
        val productBrandTV: TextView
        val productNameTV:TextView
        val productImageView:ImageView
        val discountPriceTV:TextView
        val priceTV:TextView
        val discountTV:TextView



        init {
            productImageView=view.findViewById(R.id.productImageView)
            productBrandTV = view.findViewById(R.id.productBrandTV)
            productNameTV=view.findViewById(R.id.productNameTV)
            discountPriceTV = view.findViewById(R.id.discountPriceTV)
            priceTV=view.findViewById(R.id.priceTV)
            discountTV=view.findViewById(R.id.discountTV)
        }
    }

}