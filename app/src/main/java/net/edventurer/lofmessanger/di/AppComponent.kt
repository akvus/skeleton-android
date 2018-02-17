package net.edventurer.lofmessanger.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by akvus on 2/17/18.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class,
    ActivityBuilder::class, HelpersModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<DaggerApplication> {
    fun inject(app: Application)
    override fun inject(instance: DaggerApplication)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}