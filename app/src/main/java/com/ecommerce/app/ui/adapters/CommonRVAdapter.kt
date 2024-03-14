package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.ecommerce.app.R
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.constants.HomeViewTypeEnum
import com.ecommerce.app.data.category.Category
import com.ecommerce.app.data.home.ViewItemData
import com.ecommerce.app.databinding.ItemAddressBinding
import com.ecommerce.app.databinding.ItemBigBannerBinding
import com.ecommerce.app.databinding.ItemCategoryBinding
import com.ecommerce.app.databinding.ItemCategoryHorizontalBinding
import com.ecommerce.app.databinding.ItemHomeProductBinding
import com.ecommerce.app.databinding.ItemProductImageBinding
import com.ecommerce.app.databinding.ItemSmallBannerBinding
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.DebugHandler


class CommonRVAdapter(private val fromScreen: String, val listener: CommonSelectItemRVListerner) :
    RecyclerView.Adapter<CommonViewHolder>() {


    private val items = arrayListOf<Any>()

    fun <T> setItems(items: ArrayList<T>) {
        this.items.clear()
        this.items.addAll(items as ArrayList<*>)
        notifyDataSetChanged()
    }

    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        when (fromScreen) {

            HomeViewTypeEnum.SMALL_ICON_TYPE.value -> {

                val binding: ItemCategoryHorizontalBinding =
                    ItemCategoryHorizontalBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return CommonViewHolder(parent.context, binding, fromScreen, listener)
            }

            HomeViewTypeEnum.SMALL_BANNER_TYPE.value -> {

                val binding: ItemSmallBannerBinding =
                    ItemSmallBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return CommonViewHolder(parent.context, binding, fromScreen, listener)
            }

            HomeViewTypeEnum.BIG_BANNER_TYPE.value -> {

                val binding: ItemBigBannerBinding =
                    ItemBigBannerBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return CommonViewHolder(parent.context, binding, fromScreen, listener)
            }

            HomeViewTypeEnum.PRODUCT_CARD_TYPE.value,HomeViewTypeEnum.PRODUCT_CARD_BANNER_TYPE.value -> {

                val binding: ItemHomeProductBinding =
                    ItemHomeProductBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return CommonViewHolder(parent.context, binding, fromScreen, listener)
            }

            ScreenName.FRAGMENT_HOME_TOP_CATEGORY.value -> {

                val binding: ItemCategoryHorizontalBinding =
                    ItemCategoryHorizontalBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return CommonViewHolder(parent.context, binding, fromScreen, listener)
            }

            ScreenName.FRAGMENT_CATEGORY.value -> {

                val binding: ItemCategoryBinding =
                    ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CommonViewHolder(parent.context, binding, fromScreen, listener)
            }

            ScreenName.FRAGMENT_ADDRESS.value -> {

                val binding: ItemAddressBinding =
                    ItemAddressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return CommonViewHolder(parent.context, binding, fromScreen, listener)
            }

            else -> throw IllegalArgumentException("Invalid view type")

        }

    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class CommonViewHolder(
    private val context: Context,
    private val itemBinding: ViewBinding,
    private val fromScreen: String,
    private val listener: CommonSelectItemRVListerner
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var selectedItem: Any

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {
        selectedItem = item
        when (fromScreen) {

            HomeViewTypeEnum.SMALL_ICON_TYPE.value -> {
                item as ViewItemData
                itemBinding as ItemCategoryHorizontalBinding
                itemBinding.nameTV.text = item.name
                Glide.with(context)
                    .load(item.src)
                    .into(itemBinding.iconIV)

            }

            HomeViewTypeEnum.SMALL_BANNER_TYPE.value -> {
                item as ViewItemData
                itemBinding as ItemSmallBannerBinding
             //   itemBindiproductImageView
               /* Glide.with(context)
                    .load(item.src)
                    .into(itemBinding.productImageView)*/
            }

            HomeViewTypeEnum.BIG_BANNER_TYPE.value -> {
                item as ViewItemData
                itemBinding as ItemBigBannerBinding
               //itemBinding.root.layoutParams.height=context.resources.getDimensionPixelSize(R.dimen.height300)
                 Glide.with(context)
                     .load(item.src)
                     .into(itemBinding.backgroundImageView)
            }

            HomeViewTypeEnum.PRODUCT_CARD_TYPE.value,HomeViewTypeEnum.PRODUCT_CARD_BANNER_TYPE.value -> {
                item as ViewItemData
                itemBinding as ItemHomeProductBinding

                //itemBinding.productBrandTV.text=item!!.name
                itemBinding.productNameTV.text=item.name
                itemBinding.discountPriceTV.text=context.getString(R.string.input_rs_symbol,item.price.toString())
                itemBinding.priceTV.text=context.getString(R.string.input_rs_symbol,item.price.toString())
                itemBinding.discountTV.text="${item.discountPercentage}%"
                itemBinding.priceTV.setPaintFlags(itemBinding.priceTV.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
                Glide.with(context)
                    .load(item.src)
                    .into(itemBinding.productImageView)

                //itemBinding.cardView.setBackgroundColor(mContext.getColor(R.color.light_blue))
                // itemBinding.cardView.setBackgroundResource(R.drawable.ic_facebook);
            }

            ScreenName.FRAGMENT_CATEGORY.value -> {
                item as Category
                itemBinding as ItemCategoryBinding
                itemBinding.nameTV.text = item.name
            }

        }

    }

    override fun onClick(p0: View?) {
        DebugHandler.log("Helllo Selected Item")
        listener.onSelectItemRVType(selectedItem)
    }

}
