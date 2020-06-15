package com.pvduc9773.di.module

import com.pvduc9773.ui.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by pvduc9773 on 5/13/20.
 */
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class, ViewModelModule::class])
    abstract fun moviesActivity(): MovieActivity
}