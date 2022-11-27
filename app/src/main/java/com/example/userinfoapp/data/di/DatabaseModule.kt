package com.example.userinfoapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.userinfoapp.data.db.UserDao
import com.example.userinfoapp.data.db.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext context: Context
    ): UserDatabase = Room
        .databaseBuilder(context, UserDatabase::class.java, "user.db")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDao = userDatabase.userDao()
}