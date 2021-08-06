package com.example.androidcheckbox

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    inner class Item internal constructor(
        var ItemDrawable: Drawable,
        var ItemString: String,
        var isChecked: Boolean
    )

    internal class ViewHolder {
        var checkBox: CheckBox? = null
        var icon: ImageView? = null
        var text: TextView? = null
    }

    inner class ItemsListAdapter internal constructor(
        private val context: Context,
        private val list: List<Item>?
    ) : BaseAdapter() {
        override fun getCount(): Int {
            return list!!.size
        }

        override fun getItem(position: Int): Any {
            return list!![position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        fun isChecked(position: Int): Boolean {
            return list!![position].isChecked
        }

        override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
            var rowView = convertView

            // reuse views
            var viewHolder = ViewHolder()
            if (rowView == null) {
                val inflater = (context as Activity).layoutInflater
                rowView = inflater.inflate(R.layout.row, null)
                viewHolder.checkBox = rowView.findViewById<View>(R.id.rowCheckBox) as CheckBox
                viewHolder.icon = rowView.findViewById<View>(R.id.rowImageView) as ImageView
                viewHolder.text = rowView.findViewById<View>(R.id.rowTextView) as TextView
                rowView.tag = viewHolder
            } else {
                viewHolder = rowView.tag as ViewHolder
            }
            viewHolder.icon!!.setImageDrawable(list!![position].ItemDrawable)
            viewHolder.checkBox!!.isChecked = list[position].isChecked
            val itemStr = list[position].ItemString
            viewHolder.text!!.text = itemStr
            viewHolder.checkBox!!.tag = position

            /*
            viewHolder.checkBox.setOnCheckedChangeListener(
                    new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    list.get(position).checked = b;

                    Toast.makeText(getApplicationContext(),
                            itemStr + "onCheckedChanged\nchecked: " + b,
                            Toast.LENGTH_LONG).show();
                }
            });
            */viewHolder.checkBox!!.setOnClickListener {
                val newState = !list[position].isChecked
                list[position].isChecked = newState
                Toast.makeText(
                    applicationContext, itemStr + "의 Checking 상태는 " + newState + " 입니다",
                    Toast.LENGTH_SHORT
                ).show()
            }
            viewHolder.checkBox!!.isChecked = isChecked(position)
            return rowView
        }
    }

    var btnLookup: Button? = null
    var items: MutableList<Item>? = null
    var listView: ListView? = null
    var myItemsListAdapter: ItemsListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<View>(R.id.listview) as ListView
        btnLookup = findViewById<View>(R.id.lookup) as Button
        initItems()
        myItemsListAdapter = ItemsListAdapter(this, items)
        listView!!.adapter = myItemsListAdapter
        listView!!.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this@MainActivity,
                (parent.getItemAtPosition(position) as Item).ItemString,
                Toast.LENGTH_SHORT
            ).show()
        }
        btnLookup!!.setOnClickListener {
            var str = "Check items:\n"
            for (i in items!!.indices) {
                if (items!![i].isChecked) {
                    str += """
                        $i
                        
                        """.trimIndent()
                }
            }

            /*
                    int cnt = myItemsListAdapter.getCount();
                    for (int i=0; i<cnt; i++){
                        if(myItemsListAdapter.isChecked(i)){
                            str += i + "\n";
                        }
                    }
                    */

//                Toast.makeText(MainActivity.this,
//                        str,
//                        Toast.LENGTH_LONG).show();
        }
    }

    private fun initItems() {
        items = ArrayList()
        val arrayDrawable = resources.obtainTypedArray(R.array.resicon)
        val arrayText = resources.obtainTypedArray(R.array.restext)
        for (i in 0 until arrayDrawable.length()) {
            val d = arrayDrawable.getDrawable(i)
            val s = arrayText.getString(i)
            val b = false
            val item: Item = Item(d, s, b)
            (items as ArrayList<Item>).add(item)
        }
        arrayDrawable.recycle()
        arrayText.recycle()
    }
}