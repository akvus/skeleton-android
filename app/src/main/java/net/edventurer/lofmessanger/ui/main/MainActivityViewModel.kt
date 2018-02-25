package net.edventurer.lofmessanger.ui.main

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import net.edventurer.lofmessanger.R
import net.edventurer.lofmessanger.arch.MyViewModel
import net.edventurer.lofmessanger.db.dao.MessageDao
import net.edventurer.lofmessanger.db.data.LofMessage
import net.edventurer.lofmessanger.ext.plus
import net.edventurer.lofmessanger.net.ApiInterface
import net.edventurer.lofmessanger.tools.preferences.MyPreferences
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by akvus on 2/17/18.
 */
class MainActivityViewModel @Inject constructor(
        private val apiInterface: ApiInterface,
        private val messageDao: MessageDao,
        private val preferences: MyPreferences
) : MyViewModel<MainIntention, MainViewState>() {

    override fun process(intention: MainIntention) {
        when (intention) {
            InitIntention -> {
                retrieveMessages()
                getAllMessages()
            }
            is PostMessageIntention -> doOnPostMessage(intention.message)
            is DeleteMessageIntention -> deleteMessage(intention.message)
            RetrieveMessages -> retrieveMessages()
        }
    }

    override fun initViewState() = MainViewState.init()

    private fun doOnPostMessage(message: String) {
        if (message.isNotEmpty()) {
            with(LofMessage(message = message, nickname = preferences.getNickname())) {
                sendMessage(this)
                saveMessage(this)
                state.value = getState().copy(messagesToAdd = listOf(this))
            }
        }
    }

    private fun retrieveMessages() {
        disposables += apiInterface.getMessages(preferences.getTokenPreference(), preferences.getNickname())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it.messages.forEach { message -> saveMessage(message) }
                    state.value = getState().copy(messagesToAdd = it.messages)
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
        disposables += apiInterface.sendMessage(preferences.getTokenPreference(),
                message.nickname, message.message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    snack.value = R.string.main_snack_message_sent
                }, Timber::e)
    }

    private fun deleteMessage(message: LofMessage) {
        disposables += Observable.fromCallable { messageDao.deleteMessage(message) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    snack.value = R.string.main_snack_message_deleted
                }, Timber::e)
    }
}