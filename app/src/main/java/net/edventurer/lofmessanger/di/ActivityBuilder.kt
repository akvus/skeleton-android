package net.edventurer.lofmessanger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.edventurer.lofmessanger.ui.main.MainActivity
import net.edventurer.lofmessanger.ui.main.MainActivityModule
import net.edventurer.lofmessanger.ui.settings.SettingsActivity
import net.edventurer.lofmessanger.ui.settings.SettingsActivityModule

/**
 * Created by akvus on 2/17/18.
 */
@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SettingsActivityModule::class])
    abstract fun settingsActivity(): SettingsActivity
}
