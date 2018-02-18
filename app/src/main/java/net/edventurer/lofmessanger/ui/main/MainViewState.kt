package net.edventurer.lofmessanger.ui.main

import net.edventurer.lofmessanger.arch.ViewState
import net.edventurer.lofmessanger.db.data.Message

/**
 * Created by akvus on 2/17/18.
 */
data class MainViewState(val messages: List<Message>?): ViewState {
    companion object {
        fun init(): MainViewState {
            return MainViewState(listOf())
        }
    }
}