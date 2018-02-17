package net.edventurer.lofmessanger.ui.main

import android.arch.lifecycle.MutableLiveData
import net.edventurer.lofmessanger.arch.MyViewModel
import net.edventurer.lofmessanger.net.ApiInterface
import javax.inject.Inject



/**
 * Created by akvus on 2/17/18.
 */
class MainActivityViewModel @Inject constructor(
        private val apiInterface: ApiInterface
) : MyViewModel<MainIntention>() {
    val state: MutableLiveData<MainViewState> by lazy {
        MutableLiveData<MainViewState>()
    }

    override fun process(intention: MainIntention) {
        when(intention) {
            InitIntention -> {}
            is SendMessageIntention -> {}
            is DeleteMessageIntention -> {}
        }
    }

}