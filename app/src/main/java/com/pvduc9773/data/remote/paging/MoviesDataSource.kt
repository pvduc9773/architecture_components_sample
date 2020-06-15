package com.pvduc9773.data.remote.paging

import androidx.paging.PageKeyedDataSource
import com.pvduc9773.AppConstants
import com.pvduc9773.data.local.dao.MovieDao
import com.pvduc9773.data.model.Movie
import com.pvduc9773.data.remote.api.MovieApiService
import com.pvduc9773.data.remote.response.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by pvduc9773 on 5/18/20.
 */
class MoviesDataSource constructor(
    private val movieApiService: MovieApiService,
    private val movieDao: MovieDao
) : PageKeyedDataSource<Int, Movie>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        movieApiService.getMovies(AppConstants.API_KEY, AppConstants.LANGUAGE, 1)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.movieResults?.let {
                            movieDao.insertMovies(it)
                            callback.onResult(it, 1, 2)
                        }
                    } else {
                        Timber.d("getMovies Result: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    val errorMessage = if (t.message == null) "Unknown error" else t.message
                    Timber.d("getMovies Error Message $errorMessage")
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        val currentPage = params.key
        movieApiService.getMovies(AppConstants.API_KEY, AppConstants.LANGUAGE, currentPage)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    if (response.isSuccessful) {
                        val nextKey = currentPage + 1
                        response.body()?.movieResults?.let {
                            movieDao.insertMovies(it)
                            callback.onResult(it, nextKey)
                        }
                    }
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Timber.d("getMovies Failed Appending Page ${t.message}")
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }
}