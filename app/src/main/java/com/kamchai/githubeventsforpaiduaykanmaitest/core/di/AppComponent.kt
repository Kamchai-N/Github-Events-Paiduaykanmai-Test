package com.kamchai.githubeventsforpaiduaykanmaitest.core.di

import android.app.Application
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.application.GitHubEventApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,  ViewModelFactoryModule::class, ActivityModule::class, ApplicationModule::class, BindingModule::class, GlideModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(application: GitHubEventApplication)
}