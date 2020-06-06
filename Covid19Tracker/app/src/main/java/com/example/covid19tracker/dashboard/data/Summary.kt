package com.example.covid19tracker.dashboard.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Summary(
    @SerializedName("Countries")
    val countries: List<Country>?,
    @SerializedName("Date")
    val date: String?,
    @SerializedName("Global")
    val global: Global?
)