package net.edventurer.lofmessanger.di

import android.app.Application
import dagger.Module
import dagger.Provides
import net.edventurer.lofmessanger.db.MyDatabase
import net.edventurer.lofmessanger.net.ApiClient
import net.edventurer.lofmessanger.net.ApiInterface

/**
 * Created by akvus on 2/17/18.
 */
@Module
class HelpersModule {
    @Provides
    fun apiInterface() : ApiInterface = ApiClient.service

    @Provides
    fun database(context: Application) = MyDatabase.create(context)

    @Provides
    fun messageDeo(myDatabase: MyDatabase) = myDatabase.messageDao()
}