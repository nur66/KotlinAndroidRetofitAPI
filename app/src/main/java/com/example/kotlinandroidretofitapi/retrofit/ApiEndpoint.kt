package com.lazday.kotlinandroidretrofit.retrofit

import com.example.kotlinandroidretofitapi.MainModel
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {

    @GET("data.php")
    fun getData(): Call<MainModel>
}