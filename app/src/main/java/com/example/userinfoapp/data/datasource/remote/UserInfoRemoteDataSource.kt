package com.example.userinfoapp.data.datasource.remote

import com.example.userinfoapp.data.entity.UserResponse
import kotlinx.coroutines.flow.Flow

interface UserInfoRemoteDataSource {
    suspend fun getUserInfoListFromRemote(query: String): Flow<UserResponse>
}