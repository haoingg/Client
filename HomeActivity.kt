package com.example.starbucks

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.example.starbucks.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 키값을 적어주면 login에 있는 edit_id에서 보내준 값을 받을 수 있게됨
        binding.realid.text = intent.getStringExtra("data")

        // 상세 페이지로 넘겨주기
        binding.product1.setOnClickListener {
            var intent = Intent(this, DetailedmenuActivity::class.java)
            startActivity(intent)
        }

        // pay 페이지로 넘겨주기

        // Order 페이지로 넘겨주기
        binding.order.setOnClickListener {
            var intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        // Gift 페이지로 넘겨주기
        binding.gift.setOnClickListener {
            var intent = Intent(this, GiftActivity::class.java)
            startActivity(intent)
        }

        // Other 페이지로 넘겨주기
        binding.other.setOnClickListener {
            var intent = Intent(this, OtherActivity::class.java)
            startActivity(intent)
        }

    }
}

