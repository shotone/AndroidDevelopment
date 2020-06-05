package com.example.davaleba6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_activity.view.*

class RecyclerViewAdapter(private val movie:ArrayList<Movie>,private val activity: MainActivity): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent:ViewGroup, viewType: Int):ViewHolder{
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false))
    }

    override fun getItemCount() = movie.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.onBind()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var model:Movie
        fun onBind(){
            model = movie[adapterPosition]
            model.title = itemView.title_row_id.text.toString()
            model.description = itemView.Desctiption_row_id.text.toString()
            model.id = movie.size + 1
        }
    }

}
