package com.pvduc9773.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by pvduc9773 on 5/14/20.
 */
abstract class BaseActivity<DB : ViewDataBinding> : DaggerAppCompatActivity() {
    @Inject
    lateinit var fragmentAndroidInjector: DispatchingAndroidInjector<Fragment>
    lateinit var dataBinding: DB

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        dataBinding = setContentView(this, getLayoutRes())
    }
}