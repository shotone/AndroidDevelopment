package com.example.shualeduri

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.view.*
import kotlinx.android.synthetic.main.activity_dashboard.view.movieAvatar
import kotlinx.android.synthetic.main.activity_recycler.view.*

class RecyclerViewAdapter(private val posts:ArrayList<ItemModel>,private val activity: DashboardActivity):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_dashboard,parent,false))
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        lateinit var model:ItemModel
        fun onBind(){
            model = posts[adapterPosition]
            Glide.with(activity).load(model.poster).into(itemView.movieAvatar)
            itemView.movieTitle.text = model.title
            itemView.movieGenre.text = model.genre
            itemView.movieYear.text = model.year


        }
    }
}

