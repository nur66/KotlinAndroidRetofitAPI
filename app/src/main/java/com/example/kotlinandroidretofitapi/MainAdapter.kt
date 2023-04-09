package com.example.kotlinandroidretofitapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(val results : ArrayList<MainModel.Result>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from( parent.context ).inflate( R.layout.adapter_main,
            parent, false)
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.textView.text = result.title
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.idTextView)
    }

    fun setData(data: List<MainModel.Result>){
        results.clear()
        results.addAll( data )
        notifyDataSetChanged()
    }
}
