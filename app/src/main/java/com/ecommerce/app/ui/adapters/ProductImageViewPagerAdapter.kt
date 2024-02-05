package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.app.R
import com.ecommerce.app.data.product.ProductImage
import com.ecommerce.app.databinding.ItemProductImageBinding

class ProductImageViewPagerAdapter() : RecyclerView.Adapter<ProductImageViewPagerAdapter.ProductImageVH>() {

    private var list: List<ProductImage> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductImageVH {
        val binding: ItemProductImageBinding =
            ItemProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductImageVH(parent.context,binding)
    }


    override fun onBindViewHolder(holder: ProductImageVH, position: Int) {
        holder.bind(list[position])
    }

    fun setItem(list: List<ProductImage>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size


    class ProductImageVH(
        private val mContext: Context,
        private val itemBinding: ItemProductImageBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        //private lateinit var productImage: ProductImage

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(productImageItem: ProductImage) {
           // this.productImage = item
            itemBinding.productImageView
            Glide.with(mContext)
                .load(productImageItem.src)
                .into(itemBinding.productImageView)

        }

        override fun onClick(v: View?) {

        }

    }

}

