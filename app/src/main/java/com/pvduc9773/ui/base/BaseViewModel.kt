package com.pvduc9773.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by pvduc9773 on 5/18/20.
 */
open class BaseViewModel : ViewModel() {
    protected var compositeDisposable: CompositeDisposable? = null

    init {
        compositeDisposable = CompositeDisposable()
    }

    protected open fun addToDisposable(disposable: Disposable?) {
        if (disposable == null || compositeDisposable == null) return
        compositeDisposable?.remove(disposable)
        compositeDisposable?.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.clear()
    }
}