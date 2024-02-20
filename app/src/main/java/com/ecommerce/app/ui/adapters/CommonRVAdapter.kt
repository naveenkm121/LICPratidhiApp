package com.ecommerce.app.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.app.constants.ScreenName
import com.ecommerce.app.data.product.Category
import com.ecommerce.app.databinding.ItemCategoryBinding


class CommonRVAdapter(private val fromScreen: String) :
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

        if(fromScreen==ScreenName.CATEGORY_FRAGMENT.value){
            val binding:ItemCategoryBinding=ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CommonViewHolder(parent.context, binding, fromScreen)
        }

        return TODO("Provide the return value")
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class CommonViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemCategoryBinding,
    private val fromScreen: String,
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {


    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {
        if (fromScreen == ScreenName.CATEGORY_FRAGMENT.value) {
            item as Category
        }

        }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }




}
