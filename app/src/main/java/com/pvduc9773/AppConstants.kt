package com.pvduc9773

import androidx.paging.PagedList
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by pvduc9773 on 5/18/20.
 */
object AppConstants {
    const val DB_NAME = "Movie_Popular.db"

    /**
     * Config Network The Movie Database (TMDb)
     */
    const val API_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "eada34fc7563d877c902821ea701f353"
    const val LANGUAGE = "en-US"
    const val IMAGE_PREFIX = "https://image.tmdb.org/t/p/w500/"

    /**
     * PAGING
     * */
    const val LOAD_SIZE = 20
    const val NUMBERS_OF_THREADS = 10
    val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(LOAD_SIZE)
        .setPageSize(LOAD_SIZE)
        .build()
    val executor: Executor =
        Executors.newFixedThreadPool(NUMBERS_OF_THREADS)

}