package com.example.userinfoapp.domain.usecase

import com.example.userinfoapp.domain.model.DataModel
import com.example.userinfoapp.domain.repository.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val userInfoRepository: UserInfoRepository) {
    fun getUserInfoListFromLocal(): Flow<List<DataModel>> =
        userInfoRepository.getUserInfoListFromLocal()

    suspend fun getUserInfoListFromRemote(query: String): Flow<List<Long>> =
        userInfoRepository.getUserInfoListFromRemote(query)
}