package com.example.davaleba7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.davaleba7.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: RecyclerViewAdapter
    private var data = ArrayList<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        adapter = RecyclerViewAdapter(data,this)

        DataLoader.run {
            getRequest("/5edb4d643200002a005d26f0",object : CallBack{
                override fun onSuccess(result:String){
                    val model = Gson().fromJson(result,DataResponse::class.java)
                    for(index in model.data.indices){
                        val item = model.data[index]
                        binding.itemView = ItemModel(item.titleEN,item.descriptionEN,item.cover.toInt())

                    }
                }
            })
        }




    }





    private fun addItems(items:ItemModel){
        adapter.notifyItemInserted(data.size - 1)

    }

}