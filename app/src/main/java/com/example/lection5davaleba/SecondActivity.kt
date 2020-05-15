//package com.example.lection5davaleba
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.bumptech.glide.Glide
//import kotlinx.android.synthetic.main.activity_second.*
//
//class SecondActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_first)
//        init()
//    }
//
//    private fun init(){
//        val userModel = intent.getParcelableArrayExtra("usermodel")  as UserModel
//        firstnameView.text = userModel.data[0].firstName
//        lastnameView.text = userModel.data[0].lastName
//        avatarView.text = userModel.data[0].avatar
//        emailView.text = userModel.data[0].email
//
//    }
//}
