package net.edventurer.lofmessanger.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import net.edventurer.lofmessanger.ui.main.MainActivityViewModel

/**
 * Created by akvus on 2/17/18.
 */
@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun mainViewModel(userViewModel: MainActivityViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory( factory: MyViewModelFactory):
            ViewModelProvider.Factory
}