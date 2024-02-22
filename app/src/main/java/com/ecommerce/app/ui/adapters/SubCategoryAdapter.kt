package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.R
import com.ecommerce.app.data.category.SubCategory
import com.ecommerce.app.data.category.SubSubCategory
import com.ecommerce.app.data.filter.Filter
import com.ecommerce.app.databinding.ItemSubCategoryBinding
import com.ecommerce.app.utils.CommonSelectItemRVListerner


class SubCategoryAdapter(val listener: CommonSelectItemRVListerner) :
    RecyclerView.Adapter<SubCategoryAdapter.SubcategoryVH>() {

    protected var itemList: List<SubCategory> = listOf()

/*
    interface SelectSubCategoryTypeListener {
        fun onSelectSubCategoryType(selectedItem: SubCategory)
    }
*/

    fun setItem(list: List<SubCategory>) {
        this.itemList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryVH {
        val binding: ItemSubCategoryBinding =
            ItemSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubcategoryVH(parent.context, binding,listener)
    }

    override fun onBindViewHolder(holder: SubcategoryVH, position: Int) {
        holder.bind(itemList[position])

    }


    class SubcategoryVH(
        private val context: Context,
        private val itemBinding: ItemSubCategoryBinding,
        private val listener: CommonSelectItemRVListerner
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        private lateinit var selectedItem: SubCategory
        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: SubCategory) {
            this.selectedItem=item
            itemBinding.nameTV.setText(item.name)
            val isExpandable: Boolean = item.isSelected

            itemBinding.expandableLayout.setVisibility(if (isExpandable) View.VISIBLE else View.GONE)

            if (isExpandable) {
                itemBinding.arrowIV.setImageResource(R.drawable.ic_keyboard_arrow_up_24)
            } else {
                itemBinding.arrowIV.setImageResource(R.drawable.ic_keyboard_arrow_down_24)
            }


            val adapter = SubSubCategoryAdapter(listener)
            adapter.setItem(item.subSubCategories)
            itemBinding.recyclerView.setLayoutManager(LinearLayoutManager(context))
            itemBinding.recyclerView.setHasFixedSize(true)
            itemBinding.recyclerView.setAdapter(adapter)

            /*itemBinding.root.setOnClickListener {
               // listener.onClickedCard(item)
                listener.onSelectSubCategoryType(item)
            }*/

        }


        override fun onClick(p0: View?) {
            listener.onSelectItemRVType(selectedItem)
            //listener.onClickedCard(item)
        }
    }

}