package com.example.kotlinandroidretofitapi.retrofit

import com.example.kotlinandroidretofitapi.MainModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("data.php")
    // Karena data kita berupa Array/ List, maka dia harus dibungkus di dalam List
//    fun getData(): Call<List<MainModel>> // Jika menggunakan Jsonplaceholder
    fun getData(): Call<MainModel>
}