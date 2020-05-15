package com.example.lection5davaleba

interface CustomerCallBack {
    fun onSuccess(result:String)
    fun onFailure(errorMessage:String)
}