package com.pvduc9773.utils

import android.os.Bundle
import android.view.View
import androidx.navigation.Navigation
import timber.log.Timber

/**
 * Created by pvduc9773 on 5/19/20.
 */
object NavigationUtils {
    fun gotoFragment(view: View?, action: Int) {
        try {
            Navigation.findNavController(view!!).navigate(action)
        } catch (e: Exception) {
            Timber.d("navigation Goto Fragment $e")
        }
    }

    fun gotoFragment(view: View?, action: Int, build: Bundle?) {
        try {
            Navigation.findNavController(view!!).navigate(action, build)
        } catch (e: Exception) {
            Timber.d("navigation Goto Fragment $e")
        }
    }
}