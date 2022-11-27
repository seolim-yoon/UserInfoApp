package com.example.userinfoapp.data.mapper

import com.example.userinfoapp.data.entity.UserEntity
import com.example.userinfoapp.domain.model.UserModel

fun mapperToBUser(users: List<UserEntity>): List<UserModel> =
    users.map { user ->
        UserModel(
            user.id,
            user.avatarUrl,
            user.login,
            user.htmlUrl,
            user.itemHeart
        )
    }
