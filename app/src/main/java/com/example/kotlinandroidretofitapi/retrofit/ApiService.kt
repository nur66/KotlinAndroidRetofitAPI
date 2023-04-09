package com.example.kotlinandroidretofitapi.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    val endpoint: ApiEndpoint
    get() {
        val retrofit = Retrofit.Builder()
            .baseUrl( BASE_URL )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // karena kita butuh return dari EndPoint maka akan kita buat
        return retrofit.create(ApiEndpoint::class.java)
    }
}