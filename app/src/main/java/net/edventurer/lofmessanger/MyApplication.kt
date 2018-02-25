package net.edventurer.lofmessanger

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import net.edventurer.lofmessanger.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by akvus on 2/17/18.
 *
 * todo
 * - setting api url -> validate
 * - encryption of the messages and auth of Bob, Alice to server
 * (fork: FCM, real server)
 */
class MyApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
            DaggerAppComponent.builder().application(this).build().also {
                it.inject(this)
            }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}