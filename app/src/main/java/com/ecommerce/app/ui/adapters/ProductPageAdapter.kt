package com.ecommerce.app.ui.adapters

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.app.R
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.ui.fragments.ProductListFragment
import com.ecommerce.app.utils.DebugHandler

class ProductPageAdapter(private val context: Context, private val listener: ProductListFragment): PagingDataAdapter<ProductItem, ProductPageAdapter.ProductVH>(
    COMPARATOR) {


    interface CardItemListener {
        fun onClickedCard(productItem: ProductItem)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductPageAdapter.ProductVH {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_product, viewGroup, false)

        return ProductVH(view)
    }
    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val  product: ProductItem? =getItem(position)

        holder.productBrandTV.text=product!!.brand
        holder.productNameTV.text=product.title
        holder.discountPriceTV.text=context.getString(R.string.input_rs_symbol,product.price.toString())
        holder.priceTV.text=context.getString(R.string.input_rs_symbol,product.price.toString())
        holder.discountTV.text="${product.discountPercentage}%"
        holder.priceTV.setPaintFlags(holder.priceTV.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)

        holder.itemView.setOnClickListener {
            DebugHandler.log("Hello Adapter Product=="+product.id)
            listener.onClickedCard(product)
        }
        Glide.with(context)
            .load(product.thumbnail)
            .into(holder.productImageView)


    }



    class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
        val productBrandTV: TextView
        val productNameTV: TextView
        val productImageView: ImageView
        val discountPriceTV: TextView
        val priceTV: TextView
        val discountTV: TextView



        init {
            productImageView=view.findViewById(R.id.productImageView)
            productBrandTV = view.findViewById(R.id.productBrandTV)
            productNameTV=view.findViewById(R.id.productNameTV)
            discountPriceTV = view.findViewById(R.id.discountPriceTV)
            priceTV=view.findViewById(R.id.priceTV)
            discountTV=view.findViewById(R.id.discountTV)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ProductItem>() {
            override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
                return oldItem == newItem
            }
        }
    }

}