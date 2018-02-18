package net.edventurer.lofmessanger.ui.main

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.edventurer.lofmessanger.arch.MyViewModel
import net.edventurer.lofmessanger.db.dao.MessageDao
import net.edventurer.lofmessanger.db.data.LofMessage
import net.edventurer.lofmessanger.ext.plus
import net.edventurer.lofmessanger.net.ApiInterface
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by akvus on 2/17/18.
 */
class MainActivityViewModel @Inject constructor(
        private val apiInterface: ApiInterface,
        private val messageDao: MessageDao
) : MyViewModel<MainIntention, MainViewState>() {

    override fun process(intention: MainIntention) {
        when (intention) {
            InitIntention -> {
                retrieveMessages()
                getAllMessages()
            }
            is PostMessageIntention -> doOnPostMessage(intention.message)
            is DeleteMessageIntention -> deleteMessage(intention.id)
            RetrieveMessages -> retrieveMessages()
        }
    }

    // todo is there a better generic way? a factory?
    override fun initViewState(): MainViewState = MainViewState.init()

    private fun doOnPostMessage(message: String) {
        if (message.isNotEmpty()) {
            // todo get nickname from settings/sharedPrefs helper
            with(LofMessage(message = message, nickname = "Bob")) {
                sendMessage(this)
                saveMessage(this)
                // todo is it better to display the message after its saved or sent instead?
                state.value = getState().copy(messagesToAdd = listOf(this))
            }
        }
    }

    private fun retrieveMessages() {
        disposables += apiInterface.retrieveMessages("Bob")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.value = getState().copy(messagesToAdd = it.lofMessages)
                }, Timber::e)
    }

    private fun getAllMessages() {
        disposables += messageDao.getAllMessages()
                .take(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.value = getState().copy(messagesToAdd = it)
                }, Timber::e)
    }

    private fun saveMessage(message: LofMessage) {
        disposables += Observable.fromCallable {
            messageDao.insertMessage(message)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Timber.d("Message $message saved.")
                }
    }

    private fun sendMessage(message: LofMessage) {
        disposables += apiInterface.sendMessage(message.nickname, message.message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    // todo snack
                }, Timber::e)
    }

    private fun deleteMessage(id: String) {
        // todo retrofit
    }
}