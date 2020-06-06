package com.example.covid19tracker.activity

import com.example.covid19tracker.dashboard.data.Summary
import retrofit2.http.GET

interface Service {

    @GET("https://api.covid19api.com/summary")
    suspend fun getOverViewResponse(): Summary
}