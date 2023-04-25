package com.example.kotlinandroidretofitapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinandroidretofitapi.retrofit.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG : String = "MainActivity"

    lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStateNotSaved() {
        super.onStateNotSaved()
        setUpRecyclerView()
        getDataFromApi()
    }

    private fun setUpRecyclerView() {
        mainAdapter = MainAdapter(arrayListOf(), object : MainAdapter.OnAdapterListener {
            override fun onClick(result: MainModel.Result) {
                startActivity(
                    Intent(applicationContext, DetailActivity::class.java)
                        .putExtra("intent_title", result.title)
                        .putExtra("intent_image", result.image)
                )
//                Toast.makeText(applicationContext, result.title, Toast.LENGTH_SHORT).show()
            }

        })
        findViewById<RecyclerView>(R.id.recyclerView).adapter = mainAdapter
        findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun getDataFromApi(){
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
        ApiService.endpoint.getData()
            .enqueue(object : Callback<MainModel> {
                override fun onResponse(
                    call: Call<MainModel>,
                    response: Response<MainModel>
                ) {
                    findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                    if (response.isSuccessful){
//                        val result = response.body()
//                        printLog(result.toString())
//                        showPhotos(result!!)
                        showData(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                    printLog(t.toString())
                }

            })
    }

    private fun printLog(message: String){
        Log.d(TAG, message)
    }

    private fun showData(data: MainModel){
        val results = data.result

        mainAdapter.setData( results )
//        for (result in results){
//            printLog("title ${result.title}")
//        }
    }
}