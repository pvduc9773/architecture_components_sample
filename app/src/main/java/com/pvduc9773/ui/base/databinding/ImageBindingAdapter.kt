package com.pvduc9773.ui.base.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.pvduc9773.AppConstants
import com.pvduc9773.R

/**
 * Created by pvduc9773 on 5/14/20.
 */
object ImageBindingAdapter {
    @BindingAdapter(value = ["image_movie_url"])
    @JvmStatic
    fun imageMovieUrl(view: ImageView, path: String?) {
        Glide
            .with(view.context)
            .load(AppConstants.IMAGE_PREFIX + path)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(view)
    }
}