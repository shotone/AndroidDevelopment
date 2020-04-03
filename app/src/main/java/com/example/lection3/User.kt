package com.example.lection3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//class Account(name: Any, lastname: Any, email: Any, year:Any, gender: Any) {
//}

class Account{
    var Name: String = ""
    var Lastname: String = ""
    var Email: String = ""
    var Year: Int = 0
    var Gender: String = ""

    get() = field
    set(value){
        field = value
    }
}

//fun main(args:Array<String>){
//    val account = Account()
//    account.Email = "shota.firanashvili.1@btu.edu.ge"
//
//    println(account.Email.toString())
//}