package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.application

import android.app.Application
import com.kamchai.githubeventsforpaiduaykanmaitest.core.di.AppComponent
import com.kamchai.githubeventsforpaiduaykanmaitest.core.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class GitHubEventApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = injector

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent?.inject(this)
        Timber.plant(Timber.DebugTree())
    }
}