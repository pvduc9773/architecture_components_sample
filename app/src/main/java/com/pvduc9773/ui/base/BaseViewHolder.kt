package com.pvduc9773.ui.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by pvduc9773 on 5/14/20.
 */
class BaseViewHolder<T : ViewDataBinding>(private var binding: T) :
    RecyclerView.ViewHolder(binding.root) {
    fun getBinding(): T {
        return binding
    }
}
