package com.jasonjiu.mymoviemvvm.Utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.request.RequestOptions
import com.jasonjiu.mymoviemvvm.R

@BindingAdapter("android:imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    Glide.with(imageView.context)
        .load(Constant.IMAGE_BASE_URL + Constant.IMAGE_W500 + url)
        .into(imageView)
}