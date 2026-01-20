package com.licapps.bmmis.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.licapps.bmmis.R
import com.licapps.bmmis.data.model.topperformers.Performer
import com.licapps.bmmis.databinding.ItemPerformersBinding
import com.licapps.bmmis.utils.CommonUtility
import kotlin.random.Random

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
        val binding = ItemPerformersBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return TopPerformersViewHolder(parent.context, binding, listener)
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
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var case: Performer

    // ---------- Avatar colors ----------
    private val avatarColors = listOf(
        "#2563EB", // Blue
        "#16A34A", // Green
        "#9333EA", // Purple
        "#DC2626", // Red
        "#EA580C", // Orange
        "#0D9488", // Teal
        "#4F46E5", // Indigo
        "#DB2777"  // Pink
    )

    // Cache to avoid color flicker
    private val avatarColorCache = HashMap<Int, Int>()

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Performer) {
        this.case = item

        /* ---------------- Row background (odd / even) ---------------- */
        val position = bindingAdapterPosition
        if (position != RecyclerView.NO_POSITION) {
            itemBinding.root.setBackgroundColor(
                if (position % 2 == 0)
                    Color.parseColor("#FFFFFF")   // even
                else
                    Color.parseColor("#F8FAFC")   // odd
            )
        }

        /* ---------------- Rank / Trophy (Single Vector + Tint) ---------------- */

        if (item.srno in 1..3) {

            itemBinding.medalIV.visibility = View.VISIBLE
            itemBinding.srNoMTV.visibility = View.GONE

            // Single vector
            itemBinding.medalIV.setImageResource(R.drawable.ic_cup)

            // Tint based on rank
            val tintColorRes = when (item.srno) {
                1 -> R.color.cup_gold
                2 -> R.color.cup_silver
                3 -> R.color.cup_bronze
                else -> null
            }

            tintColorRes?.let {
                itemBinding.medalIV.imageTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(mContext, it))
            }

            // Clear any previous animation (RecyclerView safety)
            itemBinding.medalIV.clearAnimation()

            // Bounce animation ONLY for top 3
            val animation = AnimationUtils.loadAnimation(
                mContext,
                R.anim.bounce_scale
            )
            itemBinding.medalIV.startAnimation(animation)

        } else {

            // Important to avoid animation reuse
            itemBinding.medalIV.clearAnimation()
            itemBinding.medalIV.visibility = View.GONE

            itemBinding.srNoMTV.visibility = View.VISIBLE
            itemBinding.srNoMTV.text = item.srno.toString()
            itemBinding.srNoMTV.setTextColor(Color.parseColor("#64748B"))
        }


        /* ---------------- Name + Value ---------------- */
        val displayName: String
        when (item.type) {
            0 -> {
                displayName = item.devOffName
                itemBinding.nopfpMTV.text = item.nop
            }
            1 -> {
                displayName = item.devOffName
                itemBinding.nopfpMTV.text =
                    CommonUtility.convertDoubletoIndiaCurrency(item.fp)
            }
            2 -> {
                displayName = item.agName
                itemBinding.nopfpMTV.text = item.nop
            }
            3 -> {
                displayName = item.agName
                itemBinding.nopfpMTV.text =
                    CommonUtility.convertDoubletoIndiaCurrency(item.fp)
            }
            4 -> {
                displayName = item.name
                itemBinding.nopfpMTV.text = item.nop
            }
            5 -> {
                displayName = item.name
                itemBinding.nopfpMTV.text =
                    CommonUtility.convertDoubletoIndiaCurrency(item.fp)
            }
            else -> {
                displayName = ""
                itemBinding.nopfpMTV.text = ""
            }
        }

        itemBinding.doNameMTV.text = displayName

        /* ---------------- Avatar Initial ---------------- */
        itemBinding.avatarText.text =
            displayName.firstOrNull()?.uppercase() ?: "?"

        /* ---------------- Random Avatar Color (Stable) ---------------- */
        val avatarColor = avatarColorCache.getOrPut(item.srno) {
            Color.parseColor(avatarColors[Random.nextInt(avatarColors.size)])
        }
       // itemBinding.avatarText.background?.setTint(avatarColor)
        itemBinding.avatarContainer.background?.setTint(avatarColor)

        /* ---------------- Type Label ---------------- */
        itemBinding.typeMTV.text = when (item.type) {
            0, 1 -> "DO"
            2, 3 -> "Agent"
            else -> "CLIA"
        }
    }

    override fun onClick(v: View?) {
        listener.onClickedListItem(case)
    }
}
