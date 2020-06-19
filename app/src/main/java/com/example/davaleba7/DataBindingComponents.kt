package com.example.davaleba7

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object DataBindingComponents {
    @JvmStatic
    @BindingAdapter("setImage")
    fun setImage(imageView: ImageView, image:Int){
        imageView.setImageResource(image)
    }
}