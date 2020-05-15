package com.example.lection5davaleba

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {
    lateinit var model: UserModel
    lateinit var itemView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        itemView =  inflater.inflate(R.layout.fragment_first, container, false)
        init()
        activity
        return itemView
    }

    private fun init(){
        val userModel = intent.getParcelableArrayExtra("usermodel")  as UserModel

        itemView.firstnameView.text = userModel.data[0].firstName
        itemView.lastnameView.text = userModel.data[0].lastName
        itemView.avatarView.text = userModel.data[0].avatar
        itemView.emailView.text = userModel.data[0].email

    }

}
