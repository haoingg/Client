package com.example.searchviewproject

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_search.view.*
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter(private var arrayList: ArrayList<String>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var filterList = ArrayList<String>()
    lateinit var mContext: Context

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    init{
        filterList = arrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemListView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_search, parent, false)
        val itemViewHolder = ItemViewHolder(itemListView)
        mContext = parent.context
        return itemViewHolder
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_search.text = filterList[position]
        holder.itemView.tv_search.setTextColor(Color.WHITE)
        holder.itemView.item_search.setBackgroundColor(Color.TRANSPARENT)

        holder.itemView.setOnClickListener{
            val intent = Intent(mContext, DetailsActivity::class.java)
            intent.putExtra("passText", filterList[position])
            mContext.startActivity(intent)
        }
        holder.itemView.item_search.img_delete.setOnClickListener {
            if(arrayList.isNotEmpty()){
                arrayList.removeAt(position)
                Log.d("remove", "${position}")
                notifyDataSetChanged()
            }

            else
                Toast.makeText(mContext, "리스트에 원소가 없습니", Toast.LENGTH_SHORT).show()
        }
    }

//    override fun getFilter(): Filter {
//        return object : Filter(){
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charSearch = constraint.toString()
//                if (charSearch.isEmpty()) {
//                    filterList = arrayList
//                } else {
//                    val resultList = ArrayList<String>()
//                    for (row in arrayList) {
//                        if (row.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(Locale.ROOT))) {
//                            resultList.add(row)
//                        }
//                    }
//                    filterList = resultList
//                }
//                val filterResults = FilterResults()
//                filterResults.values = filterList
//                return filterResults
//            }
//            @Suppress("UNCHECKED_CAST")
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                filterList = results?.values as ArrayList<String>
//                notifyDataSetChanged()
//            }
//
//        }
//    }
}