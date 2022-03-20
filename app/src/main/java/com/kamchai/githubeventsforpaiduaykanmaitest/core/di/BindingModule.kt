package com.kamchai.githubeventsforpaiduaykanmaitest.core.di

import com.kamchai.githubeventsforpaiduaykanmaitest.data.GithubEventRepositoryImpl
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.GithubEventRepository
import dagger.Binds
import dagger.Module
import com.kamchai.githubeventsforpaiduaykanmaitest.data.ErrorRepositoryImpl
import com.kamchai.githubeventsforpaiduaykanmaitest.data.SchedulerProviderImpl
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.ErrorRepository
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.SchedulerProvider

@Module
abstract class BindingModule {

    @Binds
    abstract fun bindSchedulerProvider(repository: SchedulerProviderImpl): SchedulerProvider

    @Binds
    abstract fun bindGithubEventRepository(repository: GithubEventRepositoryImpl): GithubEventRepository

    @Binds
    abstract fun bindErrorRepository(repository: ErrorRepositoryImpl): ErrorRepository

}