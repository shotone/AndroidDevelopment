package com.example.shualeduri

import android.util.Log.d
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.nio.file.Paths
import java.util.*
import kotlin.collections.HashMap
import com.example.shualeduri.MovieResponse as MovieResponse

object DataLoader {
    private var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("https://raw.githubusercontent.com")
        .build()

    var service = retrofit.create(ApiRetrofit::class.java)

    fun getRequest(path:String,customCallBack: CustomCallBack){
        val call = service.getRequest(path)
//        val call = service.getMovies()

        call.enqueue(callback(customCallBack))
    }

    fun postRequest(path:String,parameters:HashMap<String,String>,customCallBack: CustomCallBack){
        val call = service.postRequest(path,parameters)
        call.enqueue(callback(customCallBack))
    }



    private fun callback(customCallBack: CustomCallBack):Callback<String>{
        return object : Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                d("getRequest","${t.message}")
                customCallBack.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                d("Body","${response.body()}")
                customCallBack.onSuccess(response.body().toString())

            }

        }
    }

}

interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") paths: String) : Call<String>


    @FormUrlEncoded
    @POST("{path}")
    fun postRequest(@Path("path") user: String, parameter:Map<String,String>): Call<String>
}

