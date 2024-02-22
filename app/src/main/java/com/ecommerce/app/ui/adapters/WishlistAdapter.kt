package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
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
import com.ecommerce.app.data.filter.FilterItem
import com.ecommerce.app.data.product.ProductItem
import com.ecommerce.app.data.wishlist.WishlistItem
import com.ecommerce.app.databinding.ItemFilterBinding
import com.ecommerce.app.databinding.ItemProductBinding
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.DebugHandler


class WishlistAdapter( private val listener: CommonSelectItemRVListerner) : RecyclerView.Adapter<WishlistAdapter.ProductVH>() {

    private var itemList: List<WishlistItem> = listOf()

    fun setItem(list: List<WishlistItem>) {
        this.itemList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int= itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val binding: ItemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductVH(parent.context, binding, listener)
    }
    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        holder.bind(itemList[position])

    }



    class ProductVH(
        private val context: Context,
        private val itemBinding: ItemProductBinding,
        private  val listener: CommonSelectItemRVListerner,
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener  {

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: WishlistItem) {


            itemBinding.productBrandTV.text=item.brand
            itemBinding.productNameTV.text=item.title
            itemBinding.discountPriceTV.text=context.getString(R.string.input_rs_symbol,item.price.toString())
            itemBinding.priceTV.text=context.getString(R.string.input_rs_symbol,item.price.toString())
            itemBinding.discountTV.text="${item.discount_per}%"
            itemBinding.priceTV.setPaintFlags(itemBinding.priceTV.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)

            Glide.with(context)
                .load(item.thumbnail)
                .into(itemBinding.productImageView)

            itemBinding.root.setOnClickListener{
                listener.onSelectItemRVType(item)
            }

        }



        override fun onClick(p0: View?) {

            //listener.onClickedCard(item)
        }
    }

}