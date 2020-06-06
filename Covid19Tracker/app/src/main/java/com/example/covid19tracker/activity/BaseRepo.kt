package com.example.covid19tracker.activity

import kotlinx.coroutines.Dispatchers

open class BaseRepo {
    var retrofit = RetrofitInstance.createInstance()
    val ioDispatcher = Dispatchers.IO
}