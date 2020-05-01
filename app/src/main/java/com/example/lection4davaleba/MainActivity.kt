package com.example.lection4davaleba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_posts_layout.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerViewAdapter
    private var posts = ArrayList<UserModel.Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        init()
        getUsers()
    }


    private fun init(){
        getinfo.setOnClickListener{
            openSecondActivity()
        }
    }

    private fun getUsers(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(posts,this)
        recyclerView.adapter = adapter

        DataLoader.getRequest("users",object :CustomCallBack{
            override fun onSuccess(result: String) {
                val model = Gson().fromJson(result,UserModel::class.java)
                    posts.addAll(model.data)
                    adapter.notifyDataSetChanged()
//                d("userCount","${model.data.size}") // აითემების რაოდენობა
//                d("userAvatar","${model.data[1].avatar}") // ამვოიღოთ ავატარი
            }

            override fun onFailure(errorMessage: String) {}


        })
    }

    private fun openSecondActivity() {
        val userModel = UserModel()
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("usermodel",userModel)
        startActivity(intent)
    }

}

