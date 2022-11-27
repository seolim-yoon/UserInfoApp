package com.example.userinfoapp.data.datasource.remote

import com.example.userinfoapp.data.api.UserInfoApi
import com.example.userinfoapp.data.entity.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserInfoRemoteDataSourceImpl @Inject constructor(private val userInfoApi: UserInfoApi) : UserInfoRemoteDataSource {
    override suspend fun getUserInfoListFromRemote(query: String): Flow<UserResponse> = flow {
        emit(userInfoApi.getUserInfoList(query))
    }
}