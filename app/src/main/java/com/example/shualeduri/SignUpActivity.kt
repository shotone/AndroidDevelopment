package com.example.shualeduri

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up_activity.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up_activity)
        auth = FirebaseAuth.getInstance()
        init()
        goBack()
    }

    private fun init(){
        btn_sign_up.setOnClickListener{
            SignUp()

        }
    }

    private fun goBack(){
        gobackid.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun SignUp(){
        if(useremailid.text.toString().isEmpty()){
            useremailid.error = "Please Enter Email"
            useremailid.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(useremailid.text.toString()).matches()){
            useremailid.error = "Please Enter Email"
            useremailid.requestFocus()
            return
        }

        if(passwordid.text.toString().isEmpty()){
            passwordid.error = "Please Enter Valid Password"
            passwordid.requestFocus()
            return
        }
        auth.createUserWithEmailAndPassword(useremailid.text.toString(), passwordid.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this,DashboardActivity::class.java))
                    finish()
                    Toast.makeText(baseContext, "Logged In Successfully",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(baseContext, "Sign Up failed. Try again after some time.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}