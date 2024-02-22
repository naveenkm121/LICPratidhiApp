package com.ecommerce.app.ui.adapters

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.data.category.SubSubCategory
import com.ecommerce.app.databinding.ItemSubCategoryBinding
import com.ecommerce.app.databinding.ItemSubSubCategoryBinding


class SubSubCategoryAdapter() :
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
        return SubSubCategoryVH(parent.context, binding)
    }

    override fun onBindViewHolder(holder: SubSubCategoryVH, position: Int) {
        holder.bind(itemList[position])

    }


    class SubSubCategoryVH(
        private val context: Context,
        private val itemBinding: ItemSubSubCategoryBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: SubSubCategory) {
            itemBinding.nameTV.text=item.name

        }


        override fun onClick(p0: View?) {

            //listener.onClickedCard(item)
        }
    }

}