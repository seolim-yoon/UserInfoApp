package com.example.userinfoapp.data.repository

import com.example.userinfoapp.data.datasource.local.UserInfoLocalDataSource
import com.example.userinfoapp.data.datasource.remote.UserInfoRemoteDataSource
import com.example.userinfoapp.data.mapper.mapperToBUser
import com.example.userinfoapp.domain.model.DataModel
import com.example.userinfoapp.domain.model.HeaderModel
import com.example.userinfoapp.domain.model.UserModel
import com.example.userinfoapp.domain.repository.UserInfoRepository
import com.example.userinfoapp.presentation.view.main.UserMainViewModel.Companion.GET_QUERY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val userInfoLocalDataSource: UserInfoLocalDataSource,
    private val userInfoRemoteDataSource: UserInfoRemoteDataSource
) : UserInfoRepository {
    override suspend fun updateUserHeart(itemId: Int, itemHeart: Boolean) = userInfoLocalDataSource.updateUserHeart(itemId, itemHeart)

    override fun getUserInfoListFromLocal(): Flow<List<DataModel>> = flow {
        userInfoLocalDataSource.getUserInfoListFromLocal().collect { userList ->
            emit(mapperToBUser(userList))
        }
    }.map {
        val heartList = mutableListOf<UserModel>()
        val noHeartList = mutableListOf<UserModel>()

        it.forEach { user ->
            when (user.userHeart) {
                true -> heartList.add(user)
                false -> noHeartList.add(user)
            }
        }

        listOf(HeaderModel("'${GET_QUERY}' Users (Like)")) + heartList + listOf(HeaderModel("'${GET_QUERY}' Users (No Like)")) + noHeartList
    }.flowOn(Dispatchers.IO)

    override suspend fun getUserInfoListFromRemote(query: String) {
        userInfoRemoteDataSource.getUserInfoListFromRemote(query).collect {
            userInfoLocalDataSource.insertAllUserList(it.items)
        }
    }
}