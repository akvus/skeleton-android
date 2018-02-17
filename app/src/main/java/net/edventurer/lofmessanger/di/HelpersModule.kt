package net.edventurer.lofmessanger.di

import dagger.Module
import dagger.Provides
import net.edventurer.lofmessanger.net.ApiClient
import net.edventurer.lofmessanger.net.ApiInterface

/**
 * Created by akvus on 2/17/18.
 */
@Module
class HelpersModule {
    @Provides
    fun apiInterface() : ApiInterface = ApiClient.service
}