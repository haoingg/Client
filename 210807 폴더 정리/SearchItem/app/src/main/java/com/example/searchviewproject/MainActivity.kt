package com.example.searchviewproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SearchView 색깔 지
        val searchIcon = sv_search.findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.WHITE)


        val cancelIcon = sv_search.findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.WHITE)


        val textView = sv_search.findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.WHITE)

        //리사이클러뷰와 서치뷰 연
        rv_search.layoutManager = LinearLayoutManager(rv_search.context)
        rv_search.setHasFixedSize(true)
//        sv_search.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
//            override fun onQueryTextChange(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextSubmit(newText: String?): Boolean {
//                adapter.filter.filter(newText)
//                return false
//            }
//        })

        getItemList()

    }

    private fun getItemList() {
        val listItem = ArrayList<String>()
        listItem.add("Abc")
        listItem.add("Bcd")
        listItem.add("cde")
        listItem.add("efg")
        listItem.add("hit")
        listItem.add("aqwf")
        listItem.add("xgwrg")
        listItem.add("Abc")
        listItem.add("xcghjrty")
        listItem.add("werysx")
        listItem.add("oasfap")
        adapter = RecyclerViewAdapter(listItem)
        rv_search.adapter = adapter
    }
}
