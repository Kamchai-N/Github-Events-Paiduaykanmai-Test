package com.kamchai.githubeventsforpaiduaykanmaitest.core.di

import androidx.lifecycle.ViewModel
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.detail.DetailActivity
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.detail.DetailViewModel
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.MainActivity
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun contributeDetailActivity(): DetailActivity

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

}