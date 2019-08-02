package com.test.sliidetest.data.service

import com.test.sliidetest.data.model.SlideModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {


    @GET("content")
    fun getSliideNews(
        @Query("key") key: String,
        @Query("publisherId") publisherId: String,
        @Query("userId") userId: String,
        @Query("countryCode") countryCode: String,
        @Query("language") language: String,
        @Query("limit") limit: String,
        @Query("offset") offset: String
    ): Observable<SlideModel>
}