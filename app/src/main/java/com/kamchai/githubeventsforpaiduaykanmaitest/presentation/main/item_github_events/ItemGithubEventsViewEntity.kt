package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.item_github_events

import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview.BaseViewEntity
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity

data class ItemGithubEventsViewEntity(
    val gitHub: GitHubEventEntity = GitHubEventEntity(),
    override var isError: Boolean = false
) : BaseViewEntity {

    override fun viewType(): Int = 1

    override fun clone(): BaseViewEntity = this
}