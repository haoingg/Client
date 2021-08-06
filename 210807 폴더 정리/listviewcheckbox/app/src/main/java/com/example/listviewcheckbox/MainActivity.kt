package com.example.switchbutton2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listviewcheckbox.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var userRecyclerViewAdapter: UserRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        binding.userRecyclerView.apply {
            userRecyclerViewAdapter = UserRecyclerViewAdapter()
            adapter = userRecyclerViewAdapter
            var layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }

}