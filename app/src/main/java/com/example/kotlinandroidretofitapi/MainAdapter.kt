package com.example.kotlinandroidretofitapi

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(val results : ArrayList<MainModel.Result>, val listener : OnAdapterListener)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from( parent.context ).inflate( R.layout.adapter_main,
            parent, false)
    )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = results[position]
        holder.textView.text = result.title
        Glide.with( holder.view )
            .load(result.image)
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .centerCrop()
            .into(holder.imageView)
        holder.view.setOnClickListener {
            listener.onClick( result )
        }
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.idTextView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
    }

    fun setData(data: List<MainModel.Result>){
        results.clear()
        results.addAll( data )
        notifyDataSetChanged()
    }

    // jika di klik
    interface OnAdapterListener{
        fun onClick( result : MainModel.Result )
    }
}
