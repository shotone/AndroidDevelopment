package com.example.shualeduri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_recycler.*

class DashboardActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    lateinit var adapter: RecyclerViewAdapter
    private var posts = ArrayList<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        init()



    }

    private fun init(){
        getMovie()
        auth = FirebaseAuth.getInstance()
        movies_list.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(posts,this)
        movies_list.adapter = adapter
        signoutid.setOnClickListener{
            signout()
        }
    }

    private fun signout(){
        auth.signOut()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    private fun addItems(items:ItemModel){
        posts.add(items)
        adapter.notifyItemInserted(posts.size - 1)

    }

    private fun getMovie(){

        DataLoader.run {
            getRequest("/filippella/Sample-API-Files/master/json/movies-api.json",object :CustomCallBack{
                override fun onSuccess(result: String) {
                    val model = Gson().fromJson(result,MovieResponse::class.java)
//                    d("hello","${models.data[0].year}")
                    for(index in model.data.indices){
                        val item = model.data[index]
                        addItems(ItemModel(item.id,item.poster,item.title,item.genre,item.year))
                    }


                }
            })

        }
    }


}
