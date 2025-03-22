package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.ItemPerformersBinding
import com.licapps.bmmis.utils.CommonUtility

class TopPerformersListAdapter(private val listener: CasesListItemListener) :
    RecyclerView.Adapter<TopPerformersViewHolder>() {

    interface CasesListItemListener {
        fun onClickedListItem(case: Performer)
    }

    private val items = ArrayList<Performer>()

    fun setItems(items: ArrayList<Performer>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun clear() {
        this.items.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPerformersViewHolder {
        val binding: ItemPerformersBinding =
            ItemPerformersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopPerformersViewHolder(parent.context,binding, listener)
    }

    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: TopPerformersViewHolder, position: Int) {
        holder.bind(items[position])
    }


}

class TopPerformersViewHolder(
    private val mContext: Context,
    private val itemBinding: ItemPerformersBinding,
    private val listener: TopPerformersListAdapter.CasesListItemListener,
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var case: Performer

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Performer) {
        this.case = item
        itemBinding.srNoMTV.text=item.srno.toString()
        when(item.type){
            0->{
                itemBinding.doNameMTV.text = item.devOffName
                itemBinding.nopfpMTV.text = item.nop
            } 1->{
                itemBinding.doNameMTV.text = item.devOffName
                itemBinding.nopfpMTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fp)
            } 2->{
                itemBinding.doNameMTV.text = item.agName
                itemBinding.nopfpMTV.text = item.nop
            } 3->{
                itemBinding.doNameMTV.text = item.agName
                itemBinding.nopfpMTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fp)
            } 4->{
                itemBinding.doNameMTV.text = item.name
                itemBinding.nopfpMTV.text = item.nop
            } 5->{
                itemBinding.doNameMTV.text = item.name
                itemBinding.nopfpMTV.text = CommonUtility.convertDoubletoIndiaCurrency(item.fp)
            
            }
        }
    }
    override fun onClick(v: View?) {
        listener.onClickedListItem(case)
    }
}

