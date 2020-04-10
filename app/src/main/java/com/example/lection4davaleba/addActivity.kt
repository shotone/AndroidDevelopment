package com.example.lection4davaleba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class addActivity(val activity: MainActivity) : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
    }

    private fun init(){
        editbutton.setOnClickListener {
            ItemSaved()
        }
    }


    private lateinit var adapter: RecyclerViewAdapter

    private fun ItemSaved(){
        activity.items.add(ItemModel(R.mipmap.ic_launcher, edittitleText.toString(), editdescText.toString(), Date().toString()))
        adapter.notifyItemInserted(activity.items.size - 1)
        recycleView.scrollToPosition(activity.items.size - 1)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
