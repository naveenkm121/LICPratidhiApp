package com.licapps.bmmis.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.licapps.bmmis.R
import com.licapps.bmmis.data.model.SpinnerItemModel

class SpinnerAdapter (val context: Context, var itemList: List<SpinnerItemModel>) : BaseAdapter() {


    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_item, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }

       /* if(itemList.size>position)*/
        vh.label.text = itemList[position].name

        //   val id = context.resources.getIdentifier(countryList.get(position).url, "drawable", context.packageName)
        //  vh.img.setBackgroundResource(id)

        return view
    }

    override fun getItem(position: Int): Any? {
        return itemList[position];
    }

    override fun getCount(): Int {
        return itemList.size;
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    private class ItemHolder(row: View?) {
        val label: TextView = row?.findViewById(R.id.itemNameTV) as TextView
        val img: ImageView = row?.findViewById(R.id.itemIV) as ImageView

    }

}