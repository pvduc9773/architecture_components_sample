package com.pvduc9773.data.remote.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.pvduc9773.data.local.dao.MovieDao
import com.pvduc9773.data.model.Movie
import com.pvduc9773.data.remote.api.MovieApiService

/**
 * Created by pvduc9773 on 5/18/20.
 */
class MoviesDataSourceFactory constructor(
    movieApiService: MovieApiService,
    movieDao: MovieDao
) : DataSource.Factory<Int, Movie>() {
    private var moviesLiveData = MutableLiveData<MoviesDataSource>()
    private var moviesDataSource = MoviesDataSource(movieApiService, movieDao)

    override fun create(): DataSource<Int, Movie> {
        moviesLiveData.postValue(moviesDataSource)
        return moviesDataSource
    }
}