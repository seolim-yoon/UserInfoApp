package com.example.userinfoapp.domain.model

import java.io.Serializable

sealed class DataModel

data class HeaderModel(
    val title: String
): DataModel()

data class UserModel(
    val id: Int,
    val photoUrl: String,
    val userName: String,
    val userDescription: String,
    val userHeart: Boolean
): DataModel(), Serializable
