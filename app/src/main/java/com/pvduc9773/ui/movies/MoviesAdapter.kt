package com.pvduc9773.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pvduc9773.R
import com.pvduc9773.data.model.Movie
import com.pvduc9773.databinding.ItemMovieBinding

/**
 * Created by pvduc9773 on 5/15/20.
 */
class MoviesAdapter(private val listener: MovieListener) :
    PagedListAdapter<Movie, MoviesAdapter.MoviePagedViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Movie> =
            object : DiffUtil.ItemCallback<Movie>() {
                override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Movie,
                    newItem: Movie
                ): Boolean {
                    return oldItem.id == newItem.id
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePagedViewHolder {
        val itemMovieBinding: ItemMovieBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )
        return MoviePagedViewHolder(itemMovieBinding, listener)
    }

    override fun onBindViewHolder(holder: MoviePagedViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class MoviePagedViewHolder(
        private val itemMovieBinding: ItemMovieBinding,
        private val listener: MovieListener
    ) : RecyclerView.ViewHolder(itemMovieBinding.root) {
        fun bind(movie: Movie?) {
            itemMovieBinding.imageViewCover.transitionName = movie?.id.toString()
            itemMovieBinding.movie = movie
            itemView.setOnClickListener {
                listener.onItemMovieClick(itemView, movie)
            }
        }
    }

    interface MovieListener {
        fun onItemMovieClick(itemView: View, movie: Movie?)
    }
}
