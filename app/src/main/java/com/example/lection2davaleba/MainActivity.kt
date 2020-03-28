package com.example.lection2davaleba

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun init(){
        LoginId.setOnClickListener{
            if(emailId.text.toString().isNotEmpty() && pwdId.text.toString().isNotEmpty()) {
                Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Please Fill all Fields!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
