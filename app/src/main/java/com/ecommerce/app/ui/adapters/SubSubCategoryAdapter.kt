package com.ecommerce.app.ui.adapters

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.data.category.SubCategory
import com.ecommerce.app.data.category.SubSubCategory
import com.ecommerce.app.databinding.ItemSubCategoryBinding
import com.ecommerce.app.databinding.ItemSubSubCategoryBinding
import com.ecommerce.app.utils.CommonSelectItemRVListerner


class SubSubCategoryAdapter(val listener: CommonSelectItemRVListerner) :
    RecyclerView.Adapter<SubSubCategoryAdapter.SubSubCategoryVH>() {

    private var itemList: List<SubSubCategory> = listOf()


    fun setItem(list: List<SubSubCategory>) {
        this.itemList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubSubCategoryVH {
        val binding: ItemSubSubCategoryBinding =
            ItemSubSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubSubCategoryVH(parent.context, binding,listener)
    }

    override fun onBindViewHolder(holder: SubSubCategoryVH, position: Int) {
        holder.bind(itemList[position])

    }


    class SubSubCategoryVH(
        private val context: Context,
        private val itemBinding: ItemSubSubCategoryBinding,
        private val listener: CommonSelectItemRVListerner
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        private lateinit var selectedItem: SubSubCategory
        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: SubSubCategory) {
            selectedItem=item
            itemBinding.nameTV.text=item.name

        }


        override fun onClick(p0: View?) {

            listener.onSelectItemRVType(selectedItem)
        }
    }

}