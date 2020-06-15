package com.pvduc9773.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.pvduc9773.AppConstants
import com.pvduc9773.AppExecutors
import com.pvduc9773.data.local.dao.MovieDao
import com.pvduc9773.data.model.Movie
import com.pvduc9773.data.remote.api.MovieApiService
import com.pvduc9773.data.remote.paging.MoviesDataSourceFactory

/**
 * Created by pvduc9773 on 5/18/20.
 */
class MovieRepository constructor(
    private val appExecutors: AppExecutors,
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao
) {
    private val moviesDataSourceFactory = MoviesDataSourceFactory(movieApiService, movieDao)

    private val dataPaged: LiveData<PagedList<Movie>>
    private var movie: LiveData<Movie>? = null

    init {
        dataPaged = LivePagedListBuilder<Int, Movie>(
            moviesDataSourceFactory,
            AppConstants.pagedListConfig
        )
            .setFetchExecutor(AppConstants.executor)
            .build()
    }

    // PageMovies
    fun moviePageList(): LiveData<PagedList<Movie>> {
        return dataPaged
    }

    // DetailMovie
    fun getMovie(movieId: Int) {
        movie = movieDao.getMovie(movieId)
    }

    fun movie(): LiveData<Movie>? {
        return movie
    }
}