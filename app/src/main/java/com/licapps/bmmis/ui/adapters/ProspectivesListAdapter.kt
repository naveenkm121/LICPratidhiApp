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
import com.licapps.bmmis.data.model.inactive.InactiveDOCLIA
import com.licapps.bmmis.data.model.prospectives.Prospective
import com.licapps.bmmis.databinding.ItemProspBinding
import com.licapps.bmmis.utils.CommonUtility

class CasesListAdapter(private val listener: CasesListItemListener,private val screenToShow: String) :
    RecyclerView.Adapter<CasesListViewHolder>() {

    interface CasesListItemListener {
        fun onClickedListItem(case: Prospective)
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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CasesListViewHolder {
        val binding: ItemProspBinding =
            ItemProspBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CasesListViewHolder(parent.context,binding, listener,screenToShow)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CasesListViewHolder, position: Int) =
        holder.bind(items[position])
}

class CasesListViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemProspBinding,
    private val listener: CasesListAdapter.CasesListItemListener,
    private val screenToShow:String
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

   // private lateinit var case: Prospective

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Any) {


        when (screenToShow) {
            ScreenName.PROSPECTIVE_MDRT_COMM.value -> {
                item as Prospective
                itemBinding.agencyNameTV.text = item.agencyName
                itemBinding.agencyCodeTV.text = item.agencyCode
                itemBinding.fpTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fp)
                itemBinding.nopTV.text = item.nop
                itemBinding.qualLabelTV.text=mContext.getText(R.string.qual_mdrt_comm)
                itemBinding.qualTV.text = item.qualMDRT
                itemBinding.commissionTV.visibility=View.VISIBLE
                itemBinding.commLabelTV.visibility=View.VISIBLE
                itemBinding.fpLabelTV.visibility=View.VISIBLE
                itemBinding.fpTV.visibility=View.VISIBLE
                itemBinding.commissionTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.commission)
            }
            ScreenName.PROSPECTIVE_FP.value -> {
                item as Prospective
                itemBinding.agencyNameTV.text = item.agencyName
                itemBinding.agencyCodeTV.text = item.agencyCode
                itemBinding.fpTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fp)
                itemBinding.nopTV.text = item.nop
                itemBinding.qualLabelTV.text=mContext.getText(R.string.qual_mdrt_fp)
                itemBinding.qualTV.text = item.qualMDRT
                itemBinding.commissionTV.visibility=View.INVISIBLE
                itemBinding.commLabelTV.visibility=View.INVISIBLE
                itemBinding.fpLabelTV.visibility=View.VISIBLE
                itemBinding.fpTV.visibility=View.VISIBLE
            }
            ScreenName.PROSPECTIVE_CENTURION.value ->  {
                item as Prospective
                itemBinding.agencyNameTV.text = item.agencyName
                itemBinding.agencyCodeTV.text = item.agencyCode
                itemBinding.fpTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fp)
                itemBinding.nopTV.text = item.nop
                itemBinding.qualLabelTV.text=mContext.getText(R.string.qual_centur)
                itemBinding.qualTV.text = item.qualCentury
                itemBinding.commissionTV.visibility=View.INVISIBLE
                itemBinding.commLabelTV.visibility=View.INVISIBLE
                itemBinding.fpLabelTV.visibility=View.INVISIBLE
                itemBinding.fpTV.visibility=View.INVISIBLE
            }
            ScreenName.INACTIVE_LIST_DO.value ->  {
                item as InactiveDOCLIA
                itemBinding.agencyNameTV.text = item.devname
                itemBinding.agencyCodeTV.text = item.devcd

                itemBinding.agencyNameTV.setPadding(10, 10, 10, 10);
                itemBinding.agencyCodeTV.setPadding(10, 10, 10, 10);
                itemBinding.agencyCodeTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.agencyCodeTV.setTypeface(null, Typeface.BOLD);

                itemBinding.textView35.visibility=View.GONE
                itemBinding.nopTV.visibility=View.GONE
                itemBinding.qualLabelTV.visibility=View.GONE
                itemBinding.qualTV.visibility=View.GONE
                itemBinding.commissionTV.visibility=View.GONE
                itemBinding.commLabelTV.visibility=View.GONE
                itemBinding.fpLabelTV.visibility=View.GONE
                itemBinding.fpTV.visibility=View.GONE
            }
            ScreenName.INACTIVE_LIST_CLIA.value ->  {
                item as InactiveDOCLIA
                itemBinding.agencyNameTV.text = item.clianame
                itemBinding.agencyCodeTV.text = item.cliacode

                itemBinding.agencyNameTV.setPadding(10, 10, 10, 10);
                itemBinding.agencyCodeTV.setPadding(10, 10, 10, 10);
                itemBinding.agencyCodeTV.setTextColor(ContextCompat.getColor(mContext, R.color.red))
                itemBinding.agencyCodeTV.setTypeface(null, Typeface.BOLD);

                itemBinding.textView35.visibility=View.GONE
                itemBinding.nopTV.visibility=View.GONE
                itemBinding.qualLabelTV.visibility=View.GONE
                itemBinding.qualTV.visibility=View.GONE
                itemBinding.commissionTV.visibility=View.GONE
                itemBinding.commLabelTV.visibility=View.GONE
                itemBinding.fpLabelTV.visibility=View.GONE
                itemBinding.fpTV.visibility=View.GONE
            }
        }
    }
    override fun onClick(v: View?) {
        //listener.onClickedListItem(this)
    }
}

