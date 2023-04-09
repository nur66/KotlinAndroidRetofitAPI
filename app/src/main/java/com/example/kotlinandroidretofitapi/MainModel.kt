package com.example.kotlinandroidretofitapi

// Jika mengginakan Json placeholder di mana tidak ada prefix result didepan endpoint nya
//data class MainModel(val id: Int, val title: String, val url:String)

// call api lazday menggunakan prefix result pada endpoint nya
data class MainModel(val result: ArrayList<Result>){
    data class Result(val id: Int, val title: String, val image: String)
}