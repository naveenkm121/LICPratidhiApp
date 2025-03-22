package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.R
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.channelwise.ChannelwiseNB
import com.licapps.bmmis.data.model.claims.ClaimsItem
import com.licapps.bmmis.data.model.nbforday.NBForDayItem
import com.licapps.bmmis.data.model.persistence.Persistence
import com.licapps.bmmis.databinding.ItemNbForDayBinding
import com.licapps.bmmis.utils.CommonUtility

class NBForDayListAdapter(private val forWhom: String) :
    RecyclerView.Adapter<NBForDayViewHolder>() {


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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NBForDayViewHolder {
        val binding: ItemNbForDayBinding =
            ItemNbForDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NBForDayViewHolder(parent.context, binding, forWhom)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: NBForDayViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class NBForDayViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemNbForDayBinding,
    private val forWhom: String,
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {


    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {
        if (forWhom == ScreenName.NB_FOR_DAY.value) {
            item as NBForDayItem
            itemBinding.typeMTV.text = item.type
            itemBinding.nopMTV.text = item.nop
            itemBinding.fpMTV.text = CommonUtility.convertNumtoIndiaCurrency(item.amount)
            itemBinding.activeMTV.text = item.active
            itemBinding.activeMTV.visibility = View.VISIBLE
        } else if (forWhom == ScreenName.CHANNELWISE_NB.value) {
            item as ChannelwiseNB
            itemBinding.typeMTV.text = item.type
            itemBinding.nopMTV.text = item.nop
            itemBinding.fpMTV.text = CommonUtility.convertNumtoIndiaCurrency(item.amount)
            itemBinding.activeMTV.visibility = View.GONE

            if (item.type.equals(AppConstants.TOTAL)) {
                itemBinding.typeMTV.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.red
                    )
                )
                itemBinding.nopMTV.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.red
                    )
                )
                itemBinding.fpMTV.setTextColor(
                    ContextCompat.getColor(
                        mContext,
                        R.color.red
                    )
                )
                itemBinding.typeMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.nopMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.fpMTV.setTypeface(null, Typeface.BOLD)

            }
        } else if (forWhom == ScreenName.CLAIMS.value) {
            item as ClaimsItem
            itemBinding.typeMTV.text = item.type
            itemBinding.nopMTV.text = item.booked
            itemBinding.fpMTV.text = item.settled
            itemBinding.activeMTV.text = item.os
            itemBinding.activeMTV.visibility = View.VISIBLE

            if (item.type.equals(AppConstants.TOTAL)) {
                itemBinding.typeMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.nopMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.fpMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.activeMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.typeMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.nopMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.fpMTV.setTypeface(null, Typeface.BOLD)
                itemBinding.activeMTV.setTypeface(null, Typeface.BOLD)

            }
        } else if (forWhom == ScreenName.PERSISTENCY.value) {
            item as Persistence
            itemBinding.typeMTV.text = item.type
            if (item.filter == 0) {
                itemBinding.nopMTV.text = item.noPol
                itemBinding.fpMTV.text = item.totalPol

            } else {
                itemBinding.nopMTV.text = CommonUtility.convertNumtoIndiaCurrency(item.noPol)
                itemBinding.fpMTV.text = CommonUtility.convertNumtoIndiaCurrency(item.totalPol)
            }

            itemBinding.activeMTV.text = item.persistencyPer
            itemBinding.activeMTV.visibility = View.VISIBLE

        }


    }

    override fun onClick(v: View?) {

    }

}

