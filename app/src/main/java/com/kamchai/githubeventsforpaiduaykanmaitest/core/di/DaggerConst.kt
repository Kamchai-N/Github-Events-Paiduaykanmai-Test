package com.kamchai.githubeventsforpaiduaykanmaitest.core.di

import androidx.lifecycle.ViewModel
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.detail.DetailViewModel
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.MainViewModel
import dagger.MapKey
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.reflect.KClass

@MustBeDocumented
@Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScoped

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScoped

@MustBeDocumented
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ChildFragmentScoped

@MustBeDocumented
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class AppContext