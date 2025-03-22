package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.licapps.bmmis.data.model.Wish
import com.licapps.bmmis.databinding.ItemWishRvBinding
import com.licapps.bmmis.constants.Constants

class WishesAdapter(private val listener: WishItemListener) :
    RecyclerView.Adapter<WishViewHolder>() {

    interface WishItemListener {
        fun onClickedWish(wish: Wish,x:Float,y:Float)
    }

    private val items = ArrayList<Wish>()

    fun setItems(items: ArrayList<Wish>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val binding: ItemWishRvBinding =
            ItemWishRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WishViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) =
        holder.bind(items[position])
}

class WishViewHolder(
    private val itemBinding: ItemWishRvBinding,
    private val listener: WishesAdapter.WishItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var wish: Wish

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Wish) {
        this.wish = item
        Glide.with(itemBinding.root)
            .load(Constants.BASE_URL_PROD + item.imageurl)
            .into(itemBinding.wishImageIV)
    }

    override fun onClick(v: View?) {
        listener.onClickedWish(wish,v!!.pivotX,v!!.pivotY)
    }
}

