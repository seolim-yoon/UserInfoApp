package com.example.userinfoapp.data.datasource.local

import com.example.userinfoapp.data.db.UserDao
import com.example.userinfoapp.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserInfoLocalDataSourceImpl @Inject constructor(private val userDao: UserDao): UserInfoLocalDataSource {
    override suspend fun insertAllUserList(users: List<UserEntity>): List<Long> = userDao.insertAllUserList(users)

    override suspend fun updateUserHeart(itemId: Int, itemHeart: Boolean) = userDao.updateUserHeart(itemId, itemHeart)

    override fun getUserInfoListFromLocal(): Flow<List<UserEntity>> = userDao.getUserInfoList()
}