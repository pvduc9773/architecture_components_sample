package com.pvduc9773.ui.movies

import android.view.View
import android.widget.ImageView
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.transition.TransitionInflater
import com.pvduc9773.R
import com.pvduc9773.data.model.Movie
import com.pvduc9773.databinding.FragmentMoviesBinding
import com.pvduc9773.ui.base.BaseFragment

/**
 * Created by pvduc9773 on 5/14/20.
 */
class MoviesFragment : BaseFragment<MoviesViewModel, FragmentMoviesBinding>(),
    MoviesAdapter.MovieListener {

    private lateinit var adapter: MoviesAdapter

    private val moviesViewModel: MoviesViewModel by viewModels {
        viewModelFactory
    }

    override fun getViewModel(): Class<MoviesViewModel> {
        return MoviesViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_movies
    }

    override fun init() {
        initAdapter()
        observableViewModel()
        sharedElementReturnTransition =
            TransitionInflater.from(context).inflateTransition(R.transition.move)
    }

    private fun initAdapter() {
        adapter = MoviesAdapter(this)
        val layoutManager = GridLayoutManager(context, 2)
        dataBinding.recyclerView.layoutManager = layoutManager
        dataBinding.recyclerView.setHasFixedSize(true)
        dataBinding.recyclerView.adapter = adapter
        postponeEnterTransition()
        dataBinding.recyclerView.doOnPreDraw {
            startPostponedEnterTransition()
        }
    }

    private fun observableViewModel() {
        moviesViewModel.getMovies()
        moviesViewModel.movies()?.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    override fun onItemMovieClick(itemView: View, movie: Movie?) {
        movie?.let {
            val imageView: ImageView = itemView.findViewById(R.id.imageViewCover);
            val extras = FragmentNavigatorExtras(
                imageView to movie.id.toString() // ==> Transition Name
            )
            val action =
                MoviesFragmentDirections.actionMoviesFragmentToDetailFragment(movie.id)
            findNavController().navigate(action, extras)
        }
    }
}