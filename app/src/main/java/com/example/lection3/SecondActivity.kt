package com.example.lection3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }
    private fun init(){

        saveId.setOnClickListener(){
            editInfo()
        }
    }


    private fun editInfo(){
        val intent = Intent(this, MainActivity::class.java)


        nameId.text = name1Id.text.toString()
        lastnameId.text = lastname1Id.text.toString()
        emailId.text = email1Id.text.toString()
        yearId.text = year1Id.text.toString()
        genderId.text = year1Id.text.toString()

        startActivity(intent)
    }
}

