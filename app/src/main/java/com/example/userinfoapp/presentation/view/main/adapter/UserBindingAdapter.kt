package com.example.userinfoapp.presentation.view.main.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.userinfoapp.R

object UserBindingAdapter {
    @BindingAdapter("circleImageUrl")
    @JvmStatic
    fun loadCircleImage(ivImage: ImageView, url: String) {
        Glide.with(ivImage.context)
            .load(url)
            .error(R.drawable.baseline_error_24)
            .transition(DrawableTransitionOptions().crossFade())
            .circleCrop()
            .timeout(2000)
            .into(ivImage)
    }

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(ivImage: ImageView, url: String) {
        Glide.with(ivImage.context)
            .load(url)
            .error(R.drawable.baseline_error_24)
            .transition(DrawableTransitionOptions().crossFade())
            .fitCenter()
            .timeout(2000)
            .into(ivImage)
    }
}