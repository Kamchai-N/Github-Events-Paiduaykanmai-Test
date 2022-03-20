package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main

import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview.BaseListener
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity

interface MainListener : BaseListener {
    fun onItemClicked(gitHub: GitHubEventEntity)
}