package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.data.filter.Filter
import com.ecommerce.app.data.filter.FilterItem
import com.ecommerce.app.databinding.ItemFilterBinding
import com.ecommerce.app.utils.DebugHandler


class FilterItemsAdapter(private val listener: SelectFilterItemListener) : RecyclerView.Adapter<FilterItemsAdapter.FilterItemsVH>() {

    interface SelectFilterItemListener {
        fun onSelectFilterType(selectedFilterItem: FilterItem)
    }


    private var itemList: List<FilterItem> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterItemsVH {
        val binding: ItemFilterBinding =
            ItemFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterItemsVH(parent.context, binding,listener)
    }


    override fun onBindViewHolder(holder: FilterItemsVH, position: Int) {
        holder.bind(itemList[position])
    }

    fun setItem(list: List<FilterItem>) {
        this.itemList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size


    class FilterItemsVH(
        private val mContext: Context,
        private val itemBinding: ItemFilterBinding,
       private  val listener: SelectFilterItemListener,
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        //private lateinit var productImage: ProductImage

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(filterItem: FilterItem) {


            itemBinding.filterItemCheckBox.text = filterItem.name
            itemBinding.filterItemCheckBox.isChecked=filterItem.isSelected

            itemBinding.filterItemCheckBox.setOnClickListener{
                DebugHandler.log("Naveen Checkbn")
                listener.onSelectFilterType(filterItem)
            }

        }

        override fun onClick(v: View?) {
            DebugHandler.log("Hello Ji testing")
        }


    }
}