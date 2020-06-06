package com.example.covid19tracker.dashboard

import com.example.covid19tracker.activity.BaseRepo
import com.example.covid19tracker.activity.Service
import com.example.covid19tracker.dashboard.data.Summary
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class SharedRepo: BaseRepo() {
    private val service = retrofit.create(Service::class.java)

    suspend fun onGetOverViewResponse(): MutableList<Any>{
        return withContext(ioDispatcher){
            var result = async {
                service.getOverViewResponse()
            }
            return@withContext getOrganisedSummaryResponse(
                result.await()
            )
        }
    }

    private fun getOrganisedSummaryResponse(summary: Summary): MutableList<Any>{
        val result = mutableListOf<Any>()
        summary.global?.let {it-> result.add(it) }
        summary.countries?.let {it-> result.addAll(it) }
        return result
    }
}