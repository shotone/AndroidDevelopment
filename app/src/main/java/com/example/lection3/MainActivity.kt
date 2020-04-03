package com.example.lection3

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        getProfileInfo()
        init()
    }

//    private fun getProfileInfo(){
//        val account = Account()
//        account.Email = "shota.firanashvili.1@btu.edu.ge"
//        account.Gender = "Male"
//        account.Lastname = "Piranashvili"
//        account.Name = "Shota"
//        account.Year = 1999



//    }

    private fun init(){
        changeId.setOnClickListener(){
            changeProfile()
        }
    }

    private fun changeProfile(){
        val intent = Intent(this, SecondActivity::class.java)

//        intent.putExtra("name", nameId.text.toString())
//        intent.putExtra("lastname", lastnameId.text.toString())
//        intent.putExtra("email", emailId.text.toString())
//        intent.putExtra("year", yearId.text.toString().toInt())
//        intent.putExtra("gender", genderId.text.toString())
        startActivity(intent)
        finish()


    }




}