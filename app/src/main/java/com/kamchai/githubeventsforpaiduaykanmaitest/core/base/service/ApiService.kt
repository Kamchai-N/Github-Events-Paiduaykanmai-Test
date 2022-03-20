package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.service

import com.kamchai.githubeventsforpaiduaykanmaitest.data.entity.ResponseEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiService {
    @GET("events")
    @Headers("Content-Type: application/json")
    fun gitHubEvent(
        @Header("Authorization") token: String,
    ): Single<List<ResponseEntity>>

}