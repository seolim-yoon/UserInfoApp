package com.example.userinfoapp.data.db

import androidx.room.*
import com.example.userinfoapp.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllUserList(users: List<UserEntity>): List<Long>

    @Query("UPDATE UserInfo SET itemHeart =:itemHeart  WHERE id =:itemId")
    suspend fun updateUserHeart(itemId: Int, itemHeart: Boolean)

    @Query("SELECT * FROM UserInfo")
    fun getUserInfoList(): Flow<List<UserEntity>>
}
