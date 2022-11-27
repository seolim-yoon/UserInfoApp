package com.example.userinfoapp.data.datasource.local

import com.example.userinfoapp.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface UserInfoLocalDataSource {
    suspend fun insertAllUserList(users: List<UserEntity>): List<Long>

    suspend fun updateUserHeart(itemId: Int, itemHeart: Boolean)

    fun getUserInfoListFromLocal(): Flow<List<UserEntity>>
}