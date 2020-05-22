package com.example.shualeduri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up_activity.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        init()
    }

    private fun init(){
        SignupId.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
            finish()
        }
        LoginId.setOnClickListener{
            doLogin()
        }
    }

    private fun doLogin() {
        if(emailId.text.toString().isEmpty()){
            emailId.error = "Please Enter Email"
            emailId.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailId.text.toString()).matches()){
            emailId.error = "Please Enter Email"
            emailId.requestFocus()
            return
        }

        if(pwdId.text.toString().isEmpty()){
            pwdId.error = "Please Enter Valid Password"
            pwdId.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(emailId.text.toString(), pwdId.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    updateUI(null)
                }

            }

    }


    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?){
        if(currentUser != null){
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }else{
            Toast.makeText(baseContext, "Authentication failed.",
                Toast.LENGTH_SHORT).show()
        }
    }
}
