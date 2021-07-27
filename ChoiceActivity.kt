package com.example.starbucks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.starbucks.databinding.ActivityChoiceBinding
import com.example.starbucks.databinding.ActivityGiftBinding

class ChoiceActivity : AppCompatActivity() {

    lateinit var binding: ActivityChoiceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "취향에 맞게 선택해주세요!", Toast.LENGTH_SHORT).show()
    }
}