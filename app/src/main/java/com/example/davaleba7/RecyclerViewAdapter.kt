package com.example.davaleba7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.view.*

class RecyclerViewAdapter(private val data: ArrayList<ItemModel>,private val activity: MainActivity):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_main,parent,false))
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.onBind()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var model:ItemModel
        fun onBind(){
            model = data[adapterPosition]
            Glide.with(activity).load(model.cover).into(itemView.CoverId)
            itemView.TitlId.text = model.titleEN
            itemView.DesctriptionId.text = model.descriptionEN


        }
    }

}