package com.example.covid19tracker.dashboard.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Global(
    @SerializedName("NewConfirmed")
    val newConfirmed: Int?,
    @SerializedName("NewDeaths")
    val newDeaths: Int?,
    @SerializedName("NewRecovered")
    val newRecovered: Int?,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int?,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int?,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int?
)