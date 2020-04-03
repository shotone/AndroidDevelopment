package com.example.lection3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private var name = ""
    private var lastname = ""
    private var email = ""
    private var year = 0
    private var gender = ""

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

//        name = intent!!.getString("name","")
//        lastname = intent.getString("lastname","")
//        email = intent.getString("email","")
//        gender = intent.getString("gender","")
//        year = intent.getInt("year",0)

        nameId.text = name1Id.text.toString()
        lastnameId.text = lastname1Id.text.toString()
        emailId.text = email1Id.text.toString()
        yearId.text = year1Id.text.toString()
        genderId.text = year1Id.text.toString()

        startActivity(intent)
        finish()
    }
}

