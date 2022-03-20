package com.kamchai.githubeventsforpaiduaykanmaitest.domain

import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity
import io.reactivex.Single


interface GithubEventRepository {
    fun getGitHubEventUse(): Single<List<GitHubEventEntity>>
}