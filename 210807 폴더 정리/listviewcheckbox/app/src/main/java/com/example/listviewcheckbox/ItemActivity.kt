package com.example.listviewcheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

data class User(val userId: String, val userName: String)

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
    }
}