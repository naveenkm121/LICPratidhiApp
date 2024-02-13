package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.R
import com.ecommerce.app.data.filter.Filter
import com.ecommerce.app.databinding.ItemFilterTypeBinding
import com.ecommerce.app.utils.DebugHandler

class FilterTypeAdapter(val listener: FilterTypeAdapter.SelectFilterTypeListener) :
    RecyclerView.Adapter<FilterTypeAdapter.FilterTypeVH>() {

    private var itemList: List<Filter> = listOf()

    interface SelectFilterTypeListener {
        fun onSelectFilterType(selectedFilter: Filter)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterTypeVH {
        val binding: ItemFilterTypeBinding =
            ItemFilterTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilterTypeVH(parent.context, binding, listener)
    }


    override fun onBindViewHolder(holder: FilterTypeVH, position: Int) {
        holder.bind(itemList[position])
    }

    fun setItem(list: List<Filter>) {
        this.itemList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemList.size


    class FilterTypeVH(
        private val mContext: Context,
        private val itemBinding: ItemFilterTypeBinding,
        private val listener: SelectFilterTypeListener
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        //private lateinit var productImage: ProductImage

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(filter: Filter) {

            if (filter.isSelected) {
                itemBinding.root.setBackgroundColor(mContext.getColor(R.color.white))
            } else {
                itemBinding.root.setBackgroundColor(mContext.getColor(R.color.dull_white))
            }

            itemBinding.filterTypeTV.text = filter.filterName
            itemBinding.root.setOnClickListener {
                listener.onSelectFilterType(filter)
            }


        }

        override fun onClick(v: View?) {
            // DebugHandler.log("Hello Ji testing")
            // listener.onSelectFilterType(f)

        }


    }
}