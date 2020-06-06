package com.example.covid19tracker.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19tracker.dashboard.data.Country
import com.example.covid19tracker.dashboard.data.Global
import kotlinx.coroutines.launch

class SharedFragmentViewModel: ViewModel() {
    private val dashboardRepo = SharedRepo()
    var countryResponse = MutableLiveData<MutableList<Country>>()
    var overViewGlobalResponse = MutableLiveData<Global>()
    var country = mutableListOf<Country>()
    var overViewResponse : Global ?= null

    fun getOverViewResponse(){
        viewModelScope.launch {
            try {
                val result = dashboardRepo.onGetOverViewResponse()

                result.forEach {
                    if(it is Global){
                        overViewResponse = it
                    }
                    if(it is Country){
                        country.add(it)
                    }
                }
                onGetResponse()
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun onGetResponse(){
        countryResponse.value = country
        overViewGlobalResponse.value = overViewResponse
    }
}