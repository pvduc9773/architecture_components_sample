package com.pvduc9773.data.remote.response

import com.google.gson.annotations.SerializedName
import com.pvduc9773.data.model.Movie

/**
 * Created by pvduc9773 on 5/18/20.
 */
data class MoviesResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("total_results")
    val totalResults: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("results")
    val movieResults: List<Movie>?
)