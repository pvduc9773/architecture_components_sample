package com.pvduc9773.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by pvduc9773 on 5/18/20.
 */
@Entity(tableName = "movies")
class Movie(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("original_language")
    val originalLanguage: String?
)