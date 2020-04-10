package com.example.lection4davaleba

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {


    val items = ArrayList<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        additem.setOnClickListener {
            AdderItemActivity()
        }

        setData()
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = RecyclerViewAdapter(items, this)
    }

    private fun AdderItemActivity() {
        val intent = Intent(this, addActivity::class.java)
        startActivity(intent)
    }

    private fun setData(){
        items.add(ItemModel(R.mipmap.ic_launcher, "title1","description1",Date().toString()))
        items.add(ItemModel(R.mipmap.ic_launcher, "title2","description2",Date().toString()))
        items.add(ItemModel(R.mipmap.ic_launcher, "title3","description3",Date().toString()))
        items.add(ItemModel(R.mipmap.ic_launcher, "title4","description4",Date().toString()))
        items.add(ItemModel(R.mipmap.ic_launcher, "title5","description5",Date().toString()))
        items.add(ItemModel(R.mipmap.ic_launcher, "title6","description6",Date().toString()))
    }

}
