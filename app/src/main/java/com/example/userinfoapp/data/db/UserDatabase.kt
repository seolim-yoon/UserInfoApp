package com.example.userinfoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.userinfoapp.data.entity.UserEntity

@Database(entities = [UserEntity::class], version = 5)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}