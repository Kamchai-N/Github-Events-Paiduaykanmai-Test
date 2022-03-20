package com.kamchai.githubeventsforpaiduaykanmaitest.data

import io.reactivex.Completable
import io.reactivex.Single
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.ErrorRepository
import javax.inject.Inject

class ErrorRepositoryImpl @Inject constructor() : ErrorRepository {
    override fun mapError(message: String?): Throwable {
        TODO("Not yet implemented")
    }

    override fun <R> mapErrorSingle(error: Throwable): Single<R> =
        Single.error(mapError(error.message))

    override fun mapErrorCompletable(error: Throwable): Completable =
        Completable.error(mapError(error.message))
}