package com.pvduc9773.ui.detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.pvduc9773.R
import com.pvduc9773.databinding.FragmentDetailBinding
import com.pvduc9773.ui.base.BaseFragment

class DetailFragment : BaseFragment<DetailViewModel, FragmentDetailBinding>() {
    private var id: Int? = null
    private val arg by navArgs<DetailFragmentArgs>()

    private val detailViewModel: DetailViewModel by viewModels {
        viewModelFactory
    }

    override fun getViewModel(): Class<DetailViewModel> {
        return DetailViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_detail
    }

    override fun init() {
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(R.transition.move)
        id = arg.id
        observableViewModel()
        dataBinding.imageViewCover.transitionName = id.toString()
    }

    private fun observableViewModel() {
        id?.let {
            detailViewModel.getMovieDetail(it)
            detailViewModel.movie()?.observe(viewLifecycleOwner, Observer { movie ->
                dataBinding.movie = movie
            })
        }
    }
}
