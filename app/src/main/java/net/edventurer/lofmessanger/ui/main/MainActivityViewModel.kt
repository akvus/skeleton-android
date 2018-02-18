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
                getMessages()
                retrieveMessages()
            }
            is PostMessageIntention -> {
                if (intention.message.isNotEmpty()) {
                    sendMessage(intention.message)
                    saveMessage(intention.message)
                }
            }
            is DeleteMessageIntention -> deleteMessage(intention.id)
            RetrieveMessages -> retrieveMessages()
        }
    }

    // todo is there a better generic way? a factory?
    override fun initViewState(): MainViewState = MainViewState.init()

    private fun retrieveMessages() {
        disposables += apiInterface.retrieveMessages("Bob")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    state.postValue(getState().copy(lofMessages = response.lofMessages))
                }, Timber::e)
    }

    private fun getMessages() {
        // todo room
    }

    private fun saveMessage(message: String) {
        disposables += Observable.fromCallable {
            messageDao.insertMessage(LofMessage(message = message, nickname = "Bob"))
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Timber.d("Message $message saved.")
                }
    }

    private fun sendMessage(message: String) {
        disposables += apiInterface.sendMessage("Bob", message)
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