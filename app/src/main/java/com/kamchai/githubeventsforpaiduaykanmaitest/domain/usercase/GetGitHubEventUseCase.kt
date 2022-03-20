package com.kamchai.githubeventsforpaiduaykanmaitest.domain.usercase

import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.usercase.RequestUseCase
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.GithubEventRepository
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity
import io.reactivex.Single
import javax.inject.Inject

class GetGitHubEventUseCase @Inject constructor(
    private val repository: GithubEventRepository
) : RequestUseCase<List<GitHubEventEntity>>() {

    override fun build(): Single<out List<GitHubEventEntity>> =
            repository.getGitHubEventUse()
}