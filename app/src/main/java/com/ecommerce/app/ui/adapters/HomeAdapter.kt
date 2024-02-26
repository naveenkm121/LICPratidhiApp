package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.constants.ViewTypeEnum
import com.ecommerce.app.data.category.Category
import com.ecommerce.app.data.home.ViewItemData
import com.ecommerce.app.data.home.ViewType
import com.ecommerce.app.databinding.CommonRecyclerViewBinding
import com.ecommerce.app.databinding.ItemCategoryBinding
import com.ecommerce.app.databinding.ItemCategoryHorizontalBinding
import com.ecommerce.app.ui.adapters.HomeViewType.BIG_BANNER_VIEW_TYPE
import com.ecommerce.app.ui.adapters.HomeViewType.PRODUCT_CARD_VIEW_TYPE
import com.ecommerce.app.ui.adapters.HomeViewType.SMALL_BANNER_VIEW_TYPE
import com.ecommerce.app.ui.adapters.HomeViewType.SMALL_ICON_VIEW_TYPE
import com.ecommerce.app.utils.CommonSelectItemRVListerner
import com.ecommerce.app.utils.DebugHandler


object HomeViewType {
         const val SMALL_ICON_VIEW_TYPE = 0
         const val SMALL_BANNER_VIEW_TYPE = 1
         const val BIG_BANNER_VIEW_TYPE = 2
         const val PRODUCT_CARD_VIEW_TYPE = 3
}

class HomeAdapter(val listener: CommonSelectItemRVListerner) : RecyclerView.Adapter<CommonHomeViewHolder>() {


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



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonHomeViewHolder {
        return when (viewType) {
            SMALL_ICON_VIEW_TYPE -> {
                val binding: CommonRecyclerViewBinding = CommonRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CommonHomeViewHolder(parent.context, binding, viewType,listener)
            }
            SMALL_BANNER_VIEW_TYPE -> {
                val binding: ItemCategoryHorizontalBinding = ItemCategoryHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CommonHomeViewHolder(parent.context, binding, viewType,listener)
            }
           BIG_BANNER_VIEW_TYPE -> {
                val binding: ItemCategoryHorizontalBinding = ItemCategoryHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
               CommonHomeViewHolder(parent.context, binding, viewType,listener)
            }
            PRODUCT_CARD_VIEW_TYPE -> {
                val binding: ItemCategoryHorizontalBinding = ItemCategoryHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CommonHomeViewHolder(parent.context, binding, viewType,listener)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: CommonHomeViewHolder, position: Int) {
        holder.bind(items[position])
    }


    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        val viewTypeData=items.get(position) as ViewType
        DebugHandler.log("getViewType=="+viewTypeData.type)
        return when (viewTypeData.type) {
            ViewTypeEnum.SMALL_ICON_TYPE.value ->SMALL_ICON_VIEW_TYPE
            ViewTypeEnum.SMALL_BANNER_TYPE.value -> SMALL_BANNER_VIEW_TYPE
            ViewTypeEnum.BIG_BANNER_TYPE.value -> BIG_BANNER_VIEW_TYPE
            ViewTypeEnum.PRODUCT_CARD_TYPE.value -> PRODUCT_CARD_VIEW_TYPE
            else ->throw IllegalArgumentException("Invalid view type")
        }
    }


}


class CommonHomeViewHolder(
    private val context: Context,
    private val itemBinding: ViewBinding,
    private val viewType: Int,
    val listener: CommonSelectItemRVListerner
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var selectedItem: Any

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {
        selectedItem = item
        when (viewType) {

            SMALL_ICON_VIEW_TYPE -> {
                item as ViewType
                itemBinding as CommonRecyclerViewBinding

                val adapter = CommonRVAdapter(ViewTypeEnum.SMALL_ICON_TYPE.value,listener)
                adapter.setItems(item.data as ArrayList<ViewItemData>)
                itemBinding.recyclerView.setLayoutManager(LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false))
                itemBinding.recyclerView.setHasFixedSize(true)
                itemBinding.recyclerView.setAdapter(adapter)
                //itemBinding.cardView.setBackgroundColor(mContext.getColor(R.color.light_blue))
                // itemBinding.cardView.setBackgroundResource(R.drawable.ic_facebook);
            }

        }

    }

    override fun onClick(p0: View?) {
        DebugHandler.log("Helllo Selected Item")
       // listener.onSelectItemRVType(selectedItem)
    }

}


