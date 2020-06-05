package com.example.davaleba6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_activity.*

class RowActivity : AppCompatActivity() {

    lateinit var db: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.row_activity)
        callBack()
        db = DBHelper(this)
    }

    private fun addMovie(){
        val movie = Movie{Integer.parseInt(title_row_id.text.toString())
            description_id.text.toString()
        }
        db.UpdateMovie(movie = movie)
        db.close()


    }

    private fun callBack(){
        saved_id.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

}