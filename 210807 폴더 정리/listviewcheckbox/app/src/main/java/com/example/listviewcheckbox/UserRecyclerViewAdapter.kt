package com.example.switchbutton2

import android.util.Log
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listviewcheckbox.User
import com.example.listviewcheckbox.databinding.ActivityItemsBinding

class UserRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val userItems = arrayListOf<User>()
    private val checkboxStatus = SparseBooleanArray()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
            = UserItemViewHolder(ActivityItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is UserItemViewHolder)
            holder.bind(userItems[position])
    }

    override fun getItemCount(): Int = if (userItems.isNullOrEmpty()) 0 else userItems.size

    fun addUserItems(user: User){
        userItems.add(user)
        notifyItemInserted(userItems.size-1)
    }

    inner class UserItemViewHolder(private val binding: ActivityItemsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userItem: User) = with(binding){
            tvUserId.text = userItem.userId
            tvUserName.text = userItem.userName

            checkboxUser.isChecked = checkboxStatus[adapterPosition]

            checkboxUser.setOnClickListener {
                if (!checkboxUser.isChecked)
                    checkboxStatus.put(adapterPosition, false)
                else
                    checkboxStatus.put(adapterPosition, true)
                notifyItemChanged(adapterPosition)
            }
        }
    }
}