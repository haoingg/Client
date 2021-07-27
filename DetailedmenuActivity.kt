package com.example.starbucks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.starbucks.databinding.ActivityDetailedmenuBinding
import com.example.starbucks.databinding.ActivityHomeBinding

class DetailedmenuActivity : AppCompatActivity() {

//    val TAG: String = "로그"

    lateinit var binding: ActivityDetailedmenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailedmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //뒤로가기 버튼 (detailed -> home)
        binding.movehome.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        // 공유하기
        binding.moveshare.setOnClickListener {
            var intent = Intent()
            intent.setAction(Intent.ACTION_SEND) // 버튼 누르면 공유 창 뜨게끔 하는 것
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_SUBJECT, title)
            intent.putExtra(Intent.EXTRA_TEXT, "내용")
            startActivity(Intent.createChooser(intent, "공유"))
        }

        //choice 페이지로 넘겨주기 (detailed -> choice)
        binding.userorder.setOnClickListener {
            var intent = Intent(this, ChoiceActivity::class.java)
            startActivity(intent)
        }

    }
}