package net.edventurer.lofmessanger.arch

import android.arch.lifecycle.ViewModel

/**
 * Created by akvus on 2/17/18.
 */
abstract class MyViewModel<in T : Intention> : ViewModel() {
    abstract fun process(intention: T)
}