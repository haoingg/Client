package com.example.switchbutton2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.switchbutton2.databinding.ActivityMainBinding


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
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        addItem()
    }

    private fun addItem(){
        binding.btnAddItem.setOnClickListener {
            userRecyclerViewAdapter?.addUserItems(User("User", "바보"))
        }
    }

}