package com.pvduc9773.ui

import com.pvduc9773.R
import com.pvduc9773.databinding.ActivityMovieBinding
import com.pvduc9773.ui.base.BaseActivity
import dagger.android.support.HasSupportFragmentInjector

class MovieActivity : BaseActivity<ActivityMovieBinding>(), HasSupportFragmentInjector {
    override fun getLayoutRes(): Int {
        return R.layout.activity_movie
    }
}
