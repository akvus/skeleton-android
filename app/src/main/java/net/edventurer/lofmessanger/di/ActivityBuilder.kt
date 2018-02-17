package net.edventurer.lofmessanger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.edventurer.lofmessanger.ui.main.MainActivity
import net.edventurer.lofmessanger.ui.main.MainActivityModule

/**
 * Created by akvus on 2/17/18.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
}
