package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.databinding.HomeRowItemBinding
import com.licapps.bmmis.utils.DebugHandler

class HomeAdapter(val itemList: ArrayList<String>, private val listener: CardItemListener) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    interface CardItemListener {
        fun onClickedCard(cardName: String)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: HomeRowItemBinding = HomeRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val v = LayoutInflater.from(parent.context).inflate(R.layout.home_row_item, parent, false)
        return ViewHolder(binding,parent.context)
    }


    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    //the class is hodling the list view
    class ViewHolder(private val itemBinding: HomeRowItemBinding,private val context:Context) :
        RecyclerView.ViewHolder(itemBinding.root) {

        @SuppressLint("ResourceAsColor")
        fun bindItems(itemName: String) {
    
            itemBinding.categoryNameTV.text = itemName
            if(itemName==AppConstants.NB){
                itemBinding.cardView.setCardBackgroundColor(context.resources.getColor(R.color.Black0Percent))
                itemBinding.cardView.cardElevation=0f
                itemBinding.categoryNameTV.setTextColor(context.resources.getColor(R.color.black))
                itemBinding.categoryNameTV.textSize=(context.resources.getDimension(R.dimen.text_5))
            }

            DebugHandler.log("hello "+itemName)

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(itemList[position])


        holder.itemView.setOnClickListener {
            listener.onClickedCard(itemList[position])
        }
    }


}