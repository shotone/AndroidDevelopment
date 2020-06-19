package com.example.davaleba7

import android.util.Log
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
        .baseUrl("http://www.mocky.io/v2")
        .build()

    var service = retrofit.create(ApiRetrofit::class.java)

    fun getRequest(paths: String,callBack: CallBack){
        val call = service.getRequest(paths)
        call.enqueue(callback(callBack))
    }

    private fun callback(callBack: CallBack): Callback<String> {
        return object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("getRequest", "${t.message}")
                callBack.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("Body", "${response.body()}")
                callBack.onSuccess(response.body().toString())

            }

        }
    }

}








interface ApiRetrofit {
    @GET("{path}")
    fun getRequest(@Path("path") paths: String) : Call<String>

}
