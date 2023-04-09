package com.example.kotlinandroidretofitapi.retrofit

import retrofit2.http.GET

interface ApiEndpoint {

    @GET("photos")
    fun getPhotos()
}