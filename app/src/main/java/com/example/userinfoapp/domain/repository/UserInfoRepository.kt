package com.example.userinfoapp.domain.repository

import com.example.userinfoapp.domain.model.DataModel
import kotlinx.coroutines.flow.Flow

interface UserInfoRepository {
    suspend fun updateUserHeart(itemId: Int, itemHeart: Boolean)

    fun getUserInfoListFromLocal(): Flow<List<DataModel>>

    suspend fun getUserInfoListFromRemote(query: String)
}