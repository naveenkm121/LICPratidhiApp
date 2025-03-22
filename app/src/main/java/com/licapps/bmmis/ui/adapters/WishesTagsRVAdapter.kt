package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.R
import com.licapps.bmmis.data.model.WishTag
import com.licapps.bmmis.databinding.ItemWishtagsRvBinding

class WishesTagsRVAdapter(private val listener: WishTagsItemListener) :
    RecyclerView.Adapter<WishTagsViewHolder>() {

    interface WishTagsItemListener {
        fun onClickedWishTag(wishTag: WishTag)
    }

    var items = mutableListOf<WishTag>(
        WishTag(0, "All", true)
        )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishTagsViewHolder {
        val binding: ItemWishtagsRvBinding =
            ItemWishtagsRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WishTagsViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WishTagsViewHolder, position: Int) =
        holder.bind(items[position])


}

class WishTagsViewHolder(
    private val itemBinding: ItemWishtagsRvBinding,
    private val listener: WishesTagsRVAdapter.WishTagsItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var wishTag: WishTag

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("ResourceAsColor")
    fun bind(item: WishTag) {
        this.wishTag = item
        itemBinding.wishTagsValueTV.text = item.value
        if (wishTag.isSelected) {
            itemBinding.wishTagsValueTV.setTextColor(Color.parseColor("#FFFFFFFF"))
            itemBinding.wishTagsItemLYT.setBackgroundResource(R.drawable.tab_background_selected);
        } else {
            //tabNameTV.setTextColor(R.color.black)
            itemBinding.wishTagsValueTV.setTextColor(Color.parseColor("#FF000000"))
            itemBinding.wishTagsItemLYT.setBackgroundResource(R.drawable.tab_background_unselected);
        }
    }


    override fun onClick(v: View?) {

        listener.onClickedWishTag(wishTag)

    }


}

