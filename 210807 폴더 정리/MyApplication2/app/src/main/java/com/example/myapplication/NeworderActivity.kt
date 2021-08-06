package com.example.starbucks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.starbucks.databinding.ActivityNeworderBinding

// 변화하는 데이터를 data class에 묶음
data class ItemList(val name: String, val contents: String)
class NeworderActivity : AppCompatActivity() {


    var ItemListArrayList = ArrayList<ItemList>()

    //어댑터 만든 후 작성 = 메인에서도 어댑터를 만들고, 리스트뷰에 셋팅해줘야 함
    private lateinit var customAdapter: CustomAdapter
    // lateinit을 한 이유는 ArrayList를 만들었는데 추후에 데이터를 추가한 다음 초기한 셋팅을 하기 위해
    lateinit var binding: ActivityNeworderBinding // 구문 끝

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNeworderBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        for (i in 0..30) {
            ItemListArrayList.add(ItemList("belle", "hello"))
            ItemListArrayList.add(ItemList("ring", "hello"))
        } // for문으로 60번 반복


        // 어댑터 셋팅
        customAdapter = CustomAdapter(this, ItemListArrayList)
        binding.listviewMain.adapter = customAdapter

    }
}