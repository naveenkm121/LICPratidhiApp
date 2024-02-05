package com.ecommerce.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.app.R
import com.ecommerce.app.data.product.ProductImage

class ProductImageViewPagerAdapter : RecyclerView.Adapter<ProductImageViewPagerAdapter.ProductImageVH>() {

    private var list: List<ProductImage> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductImageVH {
        return ProductImageVH(parent)
    }


    override fun onBindViewHolder(holder: ProductImageVH, position: Int) {
        holder.bind(list[position])
    }

    fun setItem(list: List<ProductImage>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    class ProductImageVH constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        constructor(parent: ViewGroup) : this(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_product_image,
                parent, false
            )
        )

        fun bind(imageModel: ProductImage) {
            //itemView.offerImage.setImageResource(imageModel.src)
            /*  Glide.with(context)
                  .load(imageModel.src)
                  .into(itemView.imgIntro.productImageView)*/
        }
    }
}

