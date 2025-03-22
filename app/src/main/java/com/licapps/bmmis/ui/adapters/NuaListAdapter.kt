package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.mab.MABItem
import com.licapps.bmmis.data.model.nua.NuaData
import com.licapps.bmmis.databinding.ItemMabBinding
import com.licapps.bmmis.databinding.ItemNuaBinding
import com.licapps.bmmis.utils.CommonUtility


class NuaListAdapter(private val forWhom: String) :
    RecyclerView.Adapter<NUAViewHolder>() {


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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NUAViewHolder {
        val binding: ItemNuaBinding =
            ItemNuaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NUAViewHolder(parent.context, binding, forWhom)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: NUAViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class NUAViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemNuaBinding,
    private val forWhom: String,
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {


    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {
        if (forWhom == ScreenName.NUA.value) {
            item as NuaData

            itemBinding.nameTV.text = item.username
            itemBinding.codeTV.text = item.bocode
            itemBinding.statusTV.text = "Status :: "+item.status
            itemBinding.rateSheetTV.text = item.rsno
            itemBinding.decisionTV.text=item.decision
            itemBinding.regDateTV.text=item.registrationdate
            //itemBinding.saTV.text= CommonUtility.convertDoubletoIndiaCurrency(item.sa)
            /*itemBinding.nameTV.text = item.agencyName
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

            */
        }
    }

    override fun onClick(v: View?) {


    }

}
