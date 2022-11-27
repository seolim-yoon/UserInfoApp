package com.example.userinfoapp.data.api

import com.example.userinfoapp.data.entity.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserInfoApi {
    @GET("search/users")
    suspend fun getUserInfoList(
        @Query("q") q: String
    ): UserResponse
}