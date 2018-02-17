package net.edventurer.lofmessanger.ui.main

import android.arch.lifecycle.ViewModel
import net.edventurer.lofmessanger.net.ApiInterface
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by akvus on 2/17/18.
 */
class MainActivityViewModel @Inject constructor(
        private val apiInterface: ApiInterface
) : ViewModel() {
    fun test() {
        Timber.e("TEST");
    }

}