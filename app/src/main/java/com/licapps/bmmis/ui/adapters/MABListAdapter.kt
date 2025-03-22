package com.licapps.bmmis.ui.adapters

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.mab.MABItem
import com.licapps.bmmis.databinding.ItemMabBinding
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler


class MABListAdapter(private val forWhom: String) :
    RecyclerView.Adapter<MABViewHolder>() {


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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MABViewHolder {
        val binding: ItemMabBinding =
            ItemMabBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MABViewHolder(parent.context, binding, forWhom)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: MABViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class MABViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemMabBinding,
    private val forWhom: String,
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {


    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {
        if (forWhom == ScreenName.MAB.value) {
            item as MABItem
            itemBinding.nameTV.text = item.agencyName.toString()
            itemBinding.codeTV.text = item.agencyCode
            itemBinding.nameTV.text = item.agencyName
            itemBinding.fypTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fyp)
            itemBinding.fyrpTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fyrp)
            itemBinding.noOfLivesTV.text = item.noOfLives
            itemBinding.mobileTV.text = item.mobile

            itemBinding.mobileTV.setOnClickListener {
                // CommonUtility.callNumberFromApp(mContext, item.mobile)
            }
            itemBinding.mobileImageview.setOnClickListener {
                //  CommonUtility.callNumberFromApp(mContext, item.mobile)
            }
        }
    }

    override fun onClick(v: View?) {


    }

}

