package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.constants.AppConstants
import com.licapps.bmmis.constants.ScreenName
import com.licapps.bmmis.data.model.emhr.EmhrData
import com.licapps.bmmis.data.model.nua.NuaData
import com.licapps.bmmis.data.model.planperf.PlanPerfItem
import com.licapps.bmmis.databinding.ItemEmhrBinding
import com.licapps.bmmis.databinding.ItemNuaBinding
import com.licapps.bmmis.utils.CommonUtility
import com.licapps.bmmis.utils.DebugHandler

class EMHRListAdapter (private val listener:CardItemListener) : RecyclerView.Adapter<EMHRViewHolder>() {

    interface CardItemListener {
        fun onClickedCard(cardName: String)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EMHRViewHolder {
        val binding: ItemEmhrBinding =
            ItemEmhrBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EMHRViewHolder(parent.context, binding)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: EMHRViewHolder, position: Int) {
        holder.bind(items[position])

        holder.itemView.setOnClickListener {

            DebugHandler.log("hellow ")
              //  listener.onClickedCard("hEllo")
          //  listener.onClickedCard(items[position], AppConstants.FOR_MONTH)

        }                                                                                                                                                                     /*      holder.itemView.setOnClickListener {
                                                                                                                                                                                        DebugHandler.log("Heelo sds")
                                                                                                                                                                                        listener.onClickedCard(items[position])
                                                                                                                                                                                    }

                                                                                                                                                                            */
    }


}

class EMHRViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemEmhrBinding,
) : RecyclerView.ViewHolder(itemBinding.root){

    private lateinit var item: EmhrData



    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {

             this.item=item as EmhrData

            itemBinding.accessValTV.text = item.accessid
            itemBinding.codeTV.text = "Branch :"+item.branchcode
            itemBinding.nameValTV.text = item.custname
            itemBinding.proposalTV.text= item.proposalno.toString()
            itemBinding.sucTV.text= CommonUtility.convertDoubletoIndiaCurrency(item.suc.toString())



    }




}
