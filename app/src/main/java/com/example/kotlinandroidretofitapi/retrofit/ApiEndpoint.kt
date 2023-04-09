package com.example.kotlinandroidretofitapi.retrofit

import com.example.kotlinandroidretofitapi.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("photos")
    // Karena data kita berupa Array/ List, maka dia harus dibungkus di dalam List
    fun getPhotos(): Call<List<MainModel>>
}