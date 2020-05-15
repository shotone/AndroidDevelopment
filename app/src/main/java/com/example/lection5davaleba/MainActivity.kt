package com.example.lection5davaleba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first.*

class MainActivity : AppCompatActivity() {
    private var posts = ArrayList<UserModel.Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        getUsers()
    }


    private fun init(){

        getsecondinfo.setOnClickListener{
            openFrargmentActivity()
        }
    }

    private fun getUsers(){
        val items = mutableListOf<UserModel>()


        DataLoader.getRequest("users",object :CustomerCallBack{
            override fun onSuccess(result: String) {
                val model = Gson().fromJson(result,UserModel::class.java)
                posts.addAll(model.data)
                viewPager.adapter = ViewPagerAdapter(supportFragmentManager,items)

            }

            override fun onFailure(errorMessage: String) {}


        })
    }

    private fun openFrargmentActivity() {
        val userModel = UserModel()
        val intent = Intent(this,FirstFragment::class.java)
        intent.putExtra("usermodel",userModel)
        startActivity(intent)
    }

}
