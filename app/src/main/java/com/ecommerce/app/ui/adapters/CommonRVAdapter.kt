package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.constants.ViewTypeEnum
import com.ecommerce.app.data.category.Category
import com.ecommerce.app.data.home.ViewItemData
import com.ecommerce.app.data.home.ViewType
import com.ecommerce.app.databinding.ItemCategoryBinding
import com.ecommerce.app.databinding.ItemCategoryHorizontalBinding
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

            ViewTypeEnum.SMALL_ICON_TYPE.value -> {

                val binding: ItemCategoryHorizontalBinding =
                    ItemCategoryHorizontalBinding.inflate(
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

            else -> throw IllegalArgumentException("Invalid view type")

        }

    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class CommonViewHolder(
    private val mContext: Context,
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

            ViewTypeEnum.SMALL_ICON_TYPE.value -> {
                item as ViewItemData
                itemBinding as ItemCategoryHorizontalBinding
                itemBinding.nameTV.text = item.name
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
