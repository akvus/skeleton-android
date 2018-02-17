package net.edventurer.lofmessanger.ui.main

import net.edventurer.lofmessanger.arch.MyViewModel
import net.edventurer.lofmessanger.net.ApiInterface
import javax.inject.Inject

/**
 * Created by akvus on 2/17/18.
 */
class MainActivityViewModel @Inject constructor(
        private val apiInterface: ApiInterface
) : MyViewModel<MainIntention>() {

    override fun process(intention: MainIntention) {
        when(intention) {
            is SendMessageIntention -> {}
            is DeleteMessageIntention -> {}
        }
    }

}