package com.example.userinfoapp.data.di

import com.example.userinfoapp.data.datasource.local.UserInfoLocalDataSource
import com.example.userinfoapp.data.datasource.local.UserInfoLocalDataSourceImpl
import com.example.userinfoapp.data.datasource.remote.UserInfoRemoteDataSource
import com.example.userinfoapp.data.datasource.remote.UserInfoRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DataSourceModule {
    @Binds
    fun bindUserInfoLocalDataSource(userInfoLocalDataSourceImpl: UserInfoLocalDataSourceImpl): UserInfoLocalDataSource

    @Binds
    fun bindUserInfoRemoteDataSource(userInfoRemoteDataSourceImpl: UserInfoRemoteDataSourceImpl): UserInfoRemoteDataSource
}