package com.pvduc9773.ui.movies

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.pvduc9773.AppExecutors
import com.pvduc9773.data.local.dao.MovieDao
import com.pvduc9773.data.model.Movie
import com.pvduc9773.data.remote.api.MovieApiService
import com.pvduc9773.repository.MovieRepository
import com.pvduc9773.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by pvduc9773 on 5/18/20.
 */
class MoviesViewModel @Inject constructor(
    private val appExecutors: AppExecutors,
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao
) : BaseViewModel() {
    private var movieRepository: MovieRepository? = null
    private var movies: LiveData<PagedList<Movie>>? = null

    init {
        movieRepository = MovieRepository(appExecutors, movieApiService, movieDao)
    }

    fun getMovies() {
        movies = movieRepository?.moviePageList()
    }

    fun movies(): LiveData<PagedList<Movie>>? {
        return movies
    }
}