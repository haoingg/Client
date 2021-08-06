package com.example.starbucks;

import android.widget.BaseAdapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.starbucks.databinding.ActivityNeworderItemBinding

import java.util.ArrayList

// Adapter로 기능을 하려면 BaseAdapter를 상속받아야 함
// 생성자로는 context와 ArrayList를 ItemList 형태로 만들었는데, Adapter에도 해당 데이터 타입과 동일하게 만들어줌
// 같은 형태의 ArrayList로 받아줘야 Adapter에서 셋팅을 하고, 데이터들을 컨트롤해 각 위치에 맞게 배치 가능
class CustomAdapter(context: Context, private val ItemListArrayList: ArrayList<ItemList>) :
    BaseAdapter() {

    // context는 시스템에 있는 API를 호출해 앱에 사용 가능 = 앱과 OS의 중재자 역할
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ActivityNeworderItemBinding // ItemList들을 바인딩

    // getCount는 ArrayList size 반환
    override fun getCount(): Int = ItemListArrayList.size

    // getItem은 위치 값에 따른 데이터 ex) Listview에서 두 번째 위치
    override fun getItem(p0: Int): Any = ItemListArrayList[p0]

    // getItemId는 포지션 값 반환
    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {

        // getView는 최초 시점엔 화면 크기만큼 레이아웃이 들어갈 수 있는 공간을 채울 수 있도록 호출이 되고 그 다음엔, 스크롤이 돼서 아이템이 보일 때마다 호출되는 함수
        // 이것을 하기 위해선 inflate 작업이 필요. inflater를 통해 시스템에 대한 권한 부여 받음 = xml을 메모리 상에 올려 주는 것

        binding = ActivityNeworderItemBinding.inflate(inflater, p2, false)
        // 포지션을 ArrayList[position] 값으로 접근, 그 위치에 맞는 데이터를 셋팅하는 것
        binding.itemid.text = ItemListArrayList[position].name
        // 이렇게 해주면 스크롤이 되거나 최초 시점에 그 데이터를 순서에 맞게 넣는 거라 생각
        binding.itemcontents.text = ItemListArrayList[position].contents

        return binding.root

//        val view = p1
//
//        // 함수 뒤에 '='만 작성하더라도 return type을 자동으로 추론해줌
//        view =
//
//        return view
    }
}
