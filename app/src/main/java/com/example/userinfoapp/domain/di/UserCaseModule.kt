package com.example.userinfoapp.domain.di

import com.example.userinfoapp.domain.repository.UserInfoRepository
import com.example.userinfoapp.domain.usecase.GetUserInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UserCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetUserInfoUseCase(userInfoRepository: UserInfoRepository): GetUserInfoUseCase = GetUserInfoUseCase(userInfoRepository)
}