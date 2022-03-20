package com.kamchai.githubeventsforpaiduaykanmaitest.data

import com.kamchai.githubeventsforpaiduaykanmaitest.core.TOKEN
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.service.ApiService
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.toToken
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.ErrorRepository
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.GithubEventRepository
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity
import io.reactivex.Single
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class GithubEventRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val errorRepository: ErrorRepository,
    ) : GithubEventRepository {
    override fun getGitHubEventUse(): Single<List<GitHubEventEntity>> = apiService.gitHubEvent(TOKEN.toToken()).onErrorResumeNext {
        errorRepository.mapErrorSingle(it)
    }.map {
        it.map { map ->
            GitHubEventEntity(
                id = map.id.toLong(),
                login = map.actor?.login ?: String(),
                displayLogin = map.actor?.displayLogin ?: String(),
                gravatarId = map.actor?.gravatarId ?: String(),
                url = map.actor?.url ?: String(),
                avatarUrl = map.actor?.avatarUrl ?: String(),
                type = map.type,
                repoName = map.repo?.name?: String(),
                createdAt = map.createdAt
            )
        }
    }.doOnError {
        Timber.e(it.message)
    }
}