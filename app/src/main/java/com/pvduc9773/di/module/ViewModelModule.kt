package com.pvduc9773.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pvduc9773.di.ViewModelFactory
import com.pvduc9773.ui.detail.DetailViewModel
import com.pvduc9773.ui.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by pvduc9773 on 5/13/20.
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMoviesViewModel(movieViewModel: MoviesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindMovieDetailViewModel(movieDetailViewModel: DetailViewModel): ViewModel
}