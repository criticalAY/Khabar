package com.criticalay.khabar.utils.internet

import com.criticalay.khabar.BuildConfig
import com.criticalay.khabar.data.Khabar
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("top-headlines?country=in&apiKey=${BuildConfig.NEWS_API}")
    suspend fun getTopHeadlinesCoroutine(): Khabar

    @GET("top-headlines?sources=techcrunch&apiKey=${BuildConfig.NEWS_API}")
    suspend fun getTeachCrunch():Khabar

    @GET("top-headlines?country=in&category=entertainment&apiKey=${BuildConfig.NEWS_API}")
    suspend fun getEntertainment():Khabar
}
