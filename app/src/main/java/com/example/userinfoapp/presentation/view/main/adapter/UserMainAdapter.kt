package com.example.userinfoapp.presentation.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userinfoapp.databinding.ItemHeaderBinding
import com.example.userinfoapp.databinding.ItemUserBinding
import com.example.userinfoapp.domain.model.DataModel
import com.example.userinfoapp.domain.model.HeaderModel
import com.example.userinfoapp.domain.model.UserModel
import com.example.userinfoapp.presentation.view.main.HeaderViewHolder
import com.example.userinfoapp.presentation.view.main.UserViewHolder

class UserMainAdapter(private val onItemClicked: (UserModel) -> Unit): ListAdapter<DataModel, RecyclerView.ViewHolder>(
    diffUtil
) {
    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ITEM = 1

        val diffUtil = object : DiffUtil.ItemCallback<DataModel>(){
            override fun areItemsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataModel, newItem: DataModel): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when(viewType) {
        VIEW_TYPE_HEADER -> {
            HeaderViewHolder(
                ItemHeaderBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
        else -> {
            UserViewHolder(
                ItemUserBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            ) { position ->
                if(getItem(position) is UserModel)
                    onItemClicked(getItem(position) as UserModel)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is HeaderViewHolder -> holder.bind(currentList[position] as HeaderModel)
            is UserViewHolder -> holder.bind(currentList[position] as UserModel)
        }
    }

    override fun getItemCount(): Int = currentList.size

    override fun getItemViewType(position: Int): Int = when(getItem(position)) {
        is HeaderModel -> VIEW_TYPE_HEADER
        else -> VIEW_TYPE_ITEM
    }
}