package com.kamchai.githubeventsforpaiduaykanmaitest.domain

import io.reactivex.Completable
import io.reactivex.Single

interface ErrorRepository {

    fun mapError(
        message: String?
    ): Throwable

    fun <R> mapErrorSingle(
        error: Throwable
    ): Single<R>

    fun mapErrorCompletable(
        error: Throwable
    ): Completable

}