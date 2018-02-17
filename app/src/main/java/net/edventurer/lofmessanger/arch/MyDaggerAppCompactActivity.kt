package net.edventurer.lofmessanger.arch

import dagger.android.support.DaggerAppCompatActivity

/**
 * Created by akvus on 2/17/18.
 */
abstract class MyDaggerAppCompactActivity<in VS : ViewState> : DaggerAppCompatActivity() {
    abstract fun render(viewState: VS)
}