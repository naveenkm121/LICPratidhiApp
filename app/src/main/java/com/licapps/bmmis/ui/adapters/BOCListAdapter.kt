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
import com.licapps.bmmis.data.model.boc.BOCItem
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.ItemBocBinding
import com.licapps.bmmis.databinding.ItemPerformersBinding
import com.licapps.bmmis.utils.CommonUtility

class BOCListAdapter() :
    RecyclerView.Adapter<BOCViewHolder>() {


    private val items = ArrayList<BOCItem>()

    fun setItems(items: ArrayList<BOCItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BOCViewHolder {
        val binding: ItemBocBinding =
            ItemBocBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BOCViewHolder(parent.context,binding)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: BOCViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class BOCViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemBocBinding,
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var case: BOCItem

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: BOCItem) {
        this.case = item
        itemBinding.typeMTV.text=item.type
        itemBinding.countMTV.text=item.count
        itemBinding.amtMTV.text= CommonUtility.convertNumtoIndiaCurrency(item.amount)
        if(item.type.equals(AppConstants.TOTAL))
        {
            itemBinding.typeMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
            itemBinding.countMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
            itemBinding.amtMTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
            itemBinding.typeMTV.setTypeface(null, Typeface.BOLD);
            itemBinding.countMTV.setTypeface(null, Typeface.BOLD);
            itemBinding.amtMTV.setTypeface(null, Typeface.BOLD);

        }


    }

    override fun onClick(v: View?) {

    }

}

