package com.example.connect2api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.connect2api.databinding.ActivityBikeBinding
import com.example.connect2api.databinding.ActivityMainBinding
import com.example.connect2api.databinding.ItemBikeBinding

class BikeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBikeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBikeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bikes = arrayListOf<bike>()
        for (i in 0..500) {
            bikes.add(bike("이미지1", "발산역"))
        }

        // 만든 어댑터를 리싸이클러뷰에 적용시키는 작업

        binding.recyclerbike.apply{
            layoutManager = LinearLayoutManager(this@BikeActivity)
            adapter = BikeAdapter(bikes) {bike ->
                Toast.makeText(this@BikeActivity, "$bike", Toast.LENGTH_SHORT).show()
            }

    }
}

// ** 어댑터 생성
class BikeAdapter(val bikes: List<bike>,
                  // 추가
                  private val clickListener : (bike: bike) -> Unit) :

    RecyclerView.Adapter<BikeAdapter.BikeViewHodler>(){
    // 뷰홀더 클래스 생성 -> 뷰홀더의 생성자 Binding을 받음. 이건 뭐? variable 안에 있는 것
    class BikeViewHodler(val binding : ItemBikeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BikeViewHodler {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bike, parent, false)

        val viewHolder = BikeViewHodler(ItemBikeBinding.bind(view))

        // 추가
        view.setOnClickListener{
            clickListener.invoke(bikes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BikeViewHodler, position: Int) {
        holder.binding.bike = bikes[position]
    }

    override fun getItemCount() = bikes.size
    }
}