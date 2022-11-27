package com.example.userinfoapp.presentation.view.main

import androidx.recyclerview.widget.RecyclerView
import com.example.userinfoapp.databinding.ItemUserBinding
import com.example.userinfoapp.domain.model.UserModel

class UserViewHolder(private val binding: ItemUserBinding, private val onItemClicked: (Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {
    init {
        itemView.setOnClickListener {
            onItemClicked(adapterPosition)
        }
    }

    fun bind(user: UserModel) {
        binding.user = user
    }
}