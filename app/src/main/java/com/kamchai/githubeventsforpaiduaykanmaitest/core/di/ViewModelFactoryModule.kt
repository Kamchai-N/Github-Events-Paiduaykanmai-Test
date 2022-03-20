package com.kamchai.githubeventsforpaiduaykanmaitest.core.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule{

    @Binds
    abstract fun bindViewModelFactory(baseViewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory

}