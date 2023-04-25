package com.example.kotlinandroidretofitapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.title = intent.getStringExtra("intent_title")
        lateinit var view : View
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        Glide.with( this )
            .load(intent.getStringExtra("intent_image"))
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .centerCrop()
            .into( imageView )
    }
}