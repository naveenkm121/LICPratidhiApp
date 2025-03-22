package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.data.model.planperf.PlanPerfItem
import com.licapps.bmmis.data.model.prospectives.Prospective
import com.licapps.bmmis.databinding.ItemPlanPerfBinding
import com.licapps.bmmis.databinding.ItemPlanPerformanceBinding
import com.licapps.bmmis.utils.CommonUtility

class PlanPerfListAdapter(
    private val listener: CasesListItemListener,
    private val screenToShow: String
) :
    RecyclerView.Adapter<PlanPerfListViewHolder>() {

    interface CasesListItemListener {
        fun onClickedListItem(case: PlanPerfItem)
    }

    private val items = ArrayList<PlanPerfItem>()

    fun setItems(items: ArrayList<PlanPerfItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanPerfListViewHolder {
        val binding: ItemPlanPerformanceBinding =
            ItemPlanPerformanceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlanPerfListViewHolder(parent.context, binding, listener, screenToShow)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PlanPerfListViewHolder, position: Int) =
        holder.bind(items[position])
}

class PlanPerfListViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemPlanPerformanceBinding,
    private val listener: PlanPerfListAdapter.CasesListItemListener,
    private val screenToShow: String
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var case: PlanPerfItem

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: PlanPerfItem) {
        this.case = item
        itemBinding.planMTV.text = item.plan
        itemBinding.tfpMTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.tfp)
        itemBinding.agentsMTV .text = item.actag
        itemBinding.nopMTV .text = item.nop
        itemBinding.spMTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.sp)
        itemBinding.nspMTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.nsp)


    }

    override fun onClick(v: View?) {
        listener.onClickedListItem(case)
    }
}

