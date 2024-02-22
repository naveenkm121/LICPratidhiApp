package com.ecommerce.app.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.R
import com.ecommerce.app.data.category.SubCategory
import com.ecommerce.app.data.category.SubSubCategory

class SubCategoryExpandableAdapter(private val items: List<SubCategory>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            PARENT_VIEW_TYPE -> ParentViewHolder(inflater.inflate(R.layout.item_parent, parent, false))
            CHILD_VIEW_TYPE -> ChildViewHolder(inflater.inflate(R.layout.item_child, parent, false))
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ParentViewHolder -> holder.bind(items[position] as SubCategory)
            is ChildViewHolder -> holder.bind(items[position] as SubSubCategory)
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is SubCategory) PARENT_VIEW_TYPE else CHILD_VIEW_TYPE
    }

    companion object {
        private const val PARENT_VIEW_TYPE = 0
        private const val CHILD_VIEW_TYPE = 1
    }






    class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(parentItem: SubCategory) {
            // Bind parent item data
            itemView.findViewById<TextView>(R.id.parentTitleTextView).text = parentItem.name

            // Set click listener to toggle child items
            itemView.setOnClickListener {
                // Toggle visibility of child items
            }
        }
    }

    class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(childItem: SubSubCategory) {
            // Bind child item data
            itemView.findViewById<TextView>(R.id.childTitleTextView).text = childItem.name
        }
    }

}


