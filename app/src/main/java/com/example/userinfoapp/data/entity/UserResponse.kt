package com.example.userinfoapp.data.entity

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    @SerializedName("items")
    val items: List<UserEntity>,
    @SerializedName("total_count")
    val totalCount: Int
)