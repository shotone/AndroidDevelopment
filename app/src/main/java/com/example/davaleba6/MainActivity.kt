package com.example.davaleba6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerbiewactivity.*
import kotlinx.android.synthetic.main.row_activity.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: RecyclerViewAdapter
    lateinit var db: DBHelper
    private var movies = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)
        init()
        addMovie()

        btn_delete.setOnClickListener {
            val movie = Movie(
                Integer.parseInt(title_row_id.text.toString()),
                description_id.text.toString()

            )
            db.DeleteMovie(movie = movie)
            init()
        }
    }

    private fun init(){
        movies = db.allMovie as ArrayList<Movie>
        movies_list.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter(movies,this)
        movies_list.adapter = adapter
    }

    private fun addMovie(){
        btn_add.setOnClickListener {
            startActivity(Intent(this, RowActivity::class.java))
            finish()
        }
    }


}