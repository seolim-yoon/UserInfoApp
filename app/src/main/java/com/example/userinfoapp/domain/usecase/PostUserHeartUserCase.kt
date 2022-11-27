package com.example.userinfoapp.domain.usecase

import com.example.userinfoapp.domain.repository.UserInfoRepository
import javax.inject.Inject

class PostUserHeartUserCase @Inject constructor(private val userInfoRepository: UserInfoRepository) {
    suspend fun postUserHeartState(itemId: Int, itemHeart: Boolean) = userInfoRepository.updateUserHeart(itemId, itemHeart)
}