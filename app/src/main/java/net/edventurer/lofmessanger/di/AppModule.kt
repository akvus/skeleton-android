package net.edventurer.lofmessanger.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by akvus on 2/17/18.
 */
@Module
abstract class AppModule {
    @Binds
    abstract fun context(application: Application): Context
}