package net.edventurer.lofmessanger

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.edventurer.lofmessanger.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by akvus on 2/17/18.
 *
 * todo
 * - how to not re-render unchanged data
 * - how to handle once-of events, i.e. Toast, Snackbar
 * --
 * - setup room
 * - implement app, fake server
 * (fork: FCM, real server)
 */
class EdvApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}