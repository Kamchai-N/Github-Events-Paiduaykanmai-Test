package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.usercase

import com.kamchai.githubeventsforpaiduaykanmaitest.data.SchedulerProviderImpl
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleTransformer
import javax.inject.Inject

abstract class RequestUseCase<out T>(private val scheduler: Scheduler? = null) {

    @Inject
    lateinit var appScheduler: SchedulerProviderImpl

    open fun execute(): Single<out T> = build().compose(applySchedulers())

    protected abstract fun build(): Single<out T>

    private fun applySchedulers(): SingleTransformer<T, T> =
        SingleTransformer {
            return@SingleTransformer if (scheduler != null) it.subscribeOn(scheduler) else it.subscribeOn(
                appScheduler.io()
            )
        }

}