package com.example.lection4davaleba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recyclerview_posts_layout.view.*

class RecyclerViewAdapter(private val posts:ArrayList<UserModel.Data>,private val activity: MainActivity):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private lateinit var model:UserModel.Data
         fun onBind(){
             model =posts[adapterPosition]
             Glide.with(activity)
             itemView.idView.text = model.id.toString()
             itemView.name.text = "${model.firstName} ${model.lastName}"

         }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_posts_layout, parent,
            false))
    }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind()
    }
}