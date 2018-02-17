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
            InitIntention -> init()
            is SendMessageIntention -> {
                sendMessage(intention.message)
                saveMessage(intention.message)
            }
            is DeleteMessageIntention -> deleteMessage(intention.id)
        }
    }

    private fun saveMessage(message: String) {
        // todo room
    }

    private fun init() {
        // todo get msgs from room and init state
    }

    private fun sendMessage(message: String) {
        // todo retrofit
    }

    private fun deleteMessage(id: String) {
        // todo retrofit
    }
}