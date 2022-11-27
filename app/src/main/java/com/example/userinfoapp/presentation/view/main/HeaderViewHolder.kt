package com.example.userinfoapp.presentation.view.main

import androidx.recyclerview.widget.RecyclerView
import com.example.userinfoapp.databinding.ItemHeaderBinding
import com.example.userinfoapp.domain.model.HeaderModel

class HeaderViewHolder(private val binding: ItemHeaderBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(header: HeaderModel) {
        binding.header = header
    }
}