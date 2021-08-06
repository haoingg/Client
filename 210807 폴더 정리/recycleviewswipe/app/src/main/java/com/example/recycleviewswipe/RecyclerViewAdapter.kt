package com.example.recycleviewswipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewswipe.databinding.ListItemBinding
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private val dataSet: ArrayList<List<String>> = arrayListOf<List<String>>().apply {
        for (i in 0..99) {
            add(listOf("$i th main", "$i th sub"))
        } // apply를 이용해 construct로 바로 내용이 들어가 있는 데이터 셋을 만들도록 함
    }

    // 데이터 삭제 관련 함수
    fun removeData(position: Int) {
        dataSet.removeAt(position) //dataset의 포지션을 받아와서 지정된 인덱스의 data 삭제
        notifyItemRemoved(position)
    }

    // 드래그할 때 위치 변경 관련 함수
    fun swapData(fromPos: Int, toPos: Int) {
        Collections.swap(dataSet, fromPos, toPos) // from과 to 사이의 인덱스를 바꿔줌
        notifyItemMoved(fromPos, toPos) // 바꿨다는 것을 어댑터에게 알려주는 것
    }

    fun setData(position: Int) {
        dataSet[position] = listOf("main viewholder touched!", "sub viewholder touched!")
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data:List<String>) {
            binding.tvMain.text = data[0]
            binding.tvSub.text = data[1]

//            binding.vhLayout.setOnClickListener {
//                Snackbar.make(it, "Item $layoutPosition touched!", Snackbar.LENGTH_SHORT).show()
//                setData(layoutPosition)
//            }
        }
    }
}