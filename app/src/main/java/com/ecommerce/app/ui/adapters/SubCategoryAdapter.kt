package com.ecommerce.app.ui.adapters

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.data.category.SubCategory
import com.ecommerce.app.databinding.ItemSubCategoryBinding


class SubCategoryAdapter() :
    RecyclerView.Adapter<SubCategoryAdapter.SubcategoryVH>() {

    private var itemList: List<SubCategory> = listOf()

    fun setItem(list: List<SubCategory>) {
        this.itemList = list
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = itemList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryVH {
        val binding: ItemSubCategoryBinding =
            ItemSubCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubcategoryVH(parent.context, binding)
    }

    override fun onBindViewHolder(holder: SubcategoryVH, position: Int) {
        holder.bind(itemList[position])

    }


    class SubcategoryVH(
        private val context: Context,
        private val itemBinding: ItemSubCategoryBinding,
    ) : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        init {
            itemBinding.root.setOnClickListener(this)
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: SubCategory) {
            itemBinding.nameTV.setText(item.name)

          //  val isExpandable: Boolean = item.isExpandable()
            val isExpandable=true
            itemBinding.expandableLayout.setVisibility(if (isExpandable) View.VISIBLE else View.GONE)

            if (isExpandable) {
                itemBinding.arrowIV.setImageResource(R.drawable.arrow_up_float)
            } else {
                itemBinding.arrowIV.setImageResource(R.drawable.arrow_down_float)
            }


            val adapter = SubSubCategoryAdapter()
            adapter.setItem(item.subSubCategories)
            itemBinding.recyclerView.setLayoutManager(LinearLayoutManager(context))
            itemBinding.recyclerView.setHasFixedSize(true)
            itemBinding.recyclerView.setAdapter(adapter)
            itemBinding.linearLayout.setOnClickListener(View.OnClickListener {
                //model.setExpandable(!model.isExpandable())
               // list = item.getNestedList()
               // notifyItemChanged(itemBinding.getAdapterPosition())
            })


            itemBinding.root.setOnClickListener {
               // listener.onClickedCard(item)
            }

        }


        override fun onClick(p0: View?) {

            //listener.onClickedCard(item)
        }
    }

}