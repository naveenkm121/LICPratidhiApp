package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.activisation.ActivisationItem
import com.licapps.bmmis.data.model.inactive.Inactive
import com.licapps.bmmis.data.model.resbuilding.ResBuildingItem
import com.licapps.bmmis.data.model.resource.AvailResource
import com.licapps.bmmis.databinding.ItemBocBinding

class ResBuildingListAdapter(
    private val forWhom: String,
    private val listener: ResBuildingListAdapter.ResBuildItemListener
) :
    RecyclerView.Adapter<ResBuildingViewHolder>() {

    interface ResBuildItemListener {
        fun onClickedCard(cardName: Any)
        fun onClickedCard(cardName: Any,requestType:Any)
    }

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResBuildingViewHolder {
        val binding: ItemBocBinding =
            ItemBocBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResBuildingViewHolder(parent.context, binding, forWhom)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ResBuildingViewHolder, position: Int) {

        holder.bind(items[position])
        if(forWhom == ScreenName.INACTIVE_RESOURCE.value){
//
//            holder.itemView.countMTV.setOnClickListener {
//
//                listener.onClickedCard(items[position],AppConstants.FOR_DAY)
//            }
//
//            holder.itemView.amtMTV.setOnClickListener {
//
//                listener.onClickedCard(items[position],AppConstants.FOR_MONTH)
//
//            }

        }



    }


}

class ResBuildingViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemBocBinding,
    private val forWhom: String,
) : RecyclerView.ViewHolder(itemBinding.root) {


    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {
        if (forWhom == ScreenName.RESOURCE_BUILDING.value) {
            item as ResBuildingItem
            itemBinding.typeMTV.text = item.type
            itemBinding.countMTV.text = item.forMonth
            itemBinding.amtMTV.text = item.forYear

            if (item.type.equals(AppConstants.TOTAL)) {
                itemBinding.typeMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.countMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.amtMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.typeMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.countMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.amtMTV.setTypeface(null, Typeface.BOLD)

            }
        } else if (forWhom == ScreenName.ACTIVISATION.value) {
            item as ActivisationItem
            itemBinding.typeMTV.text = item.type
            itemBinding.countMTV.text = if (!item.forDay.isNullOrBlank()) item.forDay else "NA"
            itemBinding.amtMTV.text = if (!item.forMonth.isNullOrBlank()) item.forMonth else "NA"

            if (item.type.equals(AppConstants.TOTAL)) {
                itemBinding.typeMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.countMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.amtMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.typeMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.countMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.amtMTV.setTypeface(null, Typeface.BOLD)

            }
        } else if (forWhom == ScreenName.INACTIVE_RESOURCE.value) {
            item as Inactive
            itemBinding.typeMTV.text = item.type
            itemBinding.countMTV.text = if (!item.forDay.isNullOrBlank()) item.forDay else "NA"
            itemBinding.amtMTV.text = if (!item.forMonth.isNullOrBlank()) item.forMonth else "NA"

            if (item.type.equals(AppConstants.TOTAL)) {
                itemBinding.typeMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.countMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.amtMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.typeMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.countMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.amtMTV.setTypeface(null, Typeface.BOLD)

            }

        }
        else if(forWhom==ScreenName.AVAILABLE_RESOURCE.value)
        {
            item as AvailResource
            itemBinding.typeMTV.text = item.type
            itemBinding.countMTV.isInvisible=true
            itemBinding.amtMTV.text = if (!item.count.isNullOrBlank()) item.count else "0"
            if (item.type.equals(AppConstants.TOTAL)) {
                itemBinding.typeMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.amtMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.typeMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.amtMTV.setTypeface(null, Typeface.BOLD)

            }
        }

    }


}

