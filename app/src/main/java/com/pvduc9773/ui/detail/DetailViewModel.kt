package com.pvduc9773.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.pvduc9773.AppExecutors
import com.pvduc9773.data.local.dao.MovieDao
import com.pvduc9773.data.model.Movie
import com.pvduc9773.data.remote.api.MovieApiService
import com.pvduc9773.repository.MovieRepository
import javax.inject.Inject

/**
 * Created by pvduc9773 on 5/18/20.
 */
class DetailViewModel @Inject constructor(
    private val appExecutors: AppExecutors,
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao
) : ViewModel() {
    private var movieRepository: MovieRepository? = null
    private var movie: LiveData<Movie>? = null

    init {
        movieRepository = MovieRepository(appExecutors, movieApiService, movieDao)
    }

    fun getMovieDetail(movieId: Int) {
        movieRepository?.getMovie(movieId)
        movie = movieRepository?.movie()
    }

    fun movie(): LiveData<Movie>? {
        return movie
    }
}