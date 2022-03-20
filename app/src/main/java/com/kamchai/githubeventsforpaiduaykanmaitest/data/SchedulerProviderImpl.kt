package com.kamchai.githubeventsforpaiduaykanmaitest.data

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.SchedulerProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SchedulerProviderImpl @Inject constructor() : SchedulerProvider {
    override fun io(): Scheduler = Schedulers.io()
    override fun compute(): Scheduler = Schedulers.computation()
    override fun main(): Scheduler = AndroidSchedulers.mainThread()
}