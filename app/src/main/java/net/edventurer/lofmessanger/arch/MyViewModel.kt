package net.edventurer.lofmessanger.arch

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by akvus on 2/17/18.
 */
abstract class MyViewModel<in I : Intention, VS: ViewState> : ViewModel() {
    protected var disposables = CompositeDisposable()

    val state: MutableLiveData<VS> by lazy {
        MutableLiveData<VS>()
    }

    val snack: SingleLiveEvent<Int> by lazy {
        SingleLiveEvent<Int>()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    protected fun getState(): VS {
        if (state.value != null) {
            return state.value!!
        } else {
            return initViewState()
        }
    }

    abstract fun process(intention: I)
    abstract fun initViewState(): VS
}