package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory

    val compositeDisposable = CompositeDisposable()

    open fun initViewProperties() = Unit

    open fun initListener() = Unit

    open fun initObserver() = Unit

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        RxJavaPlugins.setErrorHandler { Timber.e(it.message ?: "error") }
    }

}