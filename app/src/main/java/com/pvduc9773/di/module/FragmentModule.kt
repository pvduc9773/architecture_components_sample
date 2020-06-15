package com.pvduc9773.di.module

import com.pvduc9773.ui.detail.DetailFragment
import com.pvduc9773.ui.movies.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by pvduc9773 on 5/13/20.
 */
@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeMoviesFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeDetailFragment(): DetailFragment
}