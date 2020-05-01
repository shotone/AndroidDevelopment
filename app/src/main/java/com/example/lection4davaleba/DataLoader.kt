package com.example.lection4davaleba

import android.util.Log.d
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


object DataLoader {
    private var retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl("https://reqres.in/api/")
        .build()
    private var service = retrofit.create(ApiRetrofit::class.java)

    fun getRequest(path: String,customCallBack: CustomCallBack){
        val call = service.getRequest(path)
        call.enqueue(callBack(customCallBack)) // ინტერფეისი გადაეცემა
    }

    fun postRequest(path: String,parameters:MutableMap<String,String>,customCallBack: CustomCallBack){
        val call = service.postRequest(path,parameters)
        call.enqueue(callBack(customCallBack))
    }



    private fun callBack(customCallBack: CustomCallBack):Callback<String> = object : Callback<String>{
        override fun onFailure(call: Call<String>, t: Throwable) {
            // d("getRequest", "${t.message}")
            customCallBack.onFailure(t.message.toString())
        }

        override fun onResponse(call: Call<String>, response: Response<String>) {
            // d("getRequest", "${response.body()}")
            customCallBack.onSuccess(response.body().toString())
        }

    }
}

interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") user: String): Call<String>

    @FormUrlEncoded
    @POST("{path}")
    fun postRequest(@Path("path") user: String,parameter:Map<String,String>): Call<String>
}