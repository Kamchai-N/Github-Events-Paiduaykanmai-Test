package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.detail

import androidx.lifecycle.MutableLiveData
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.viewmodel.BaseViewModel
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.entity.GitHubEventEntity
import javax.inject.Inject

class DetailViewModel @Inject constructor(
) : BaseViewModel() {

    val data = MutableLiveData<GitHubEventEntity?>()

    fun dataData(gitHub : GitHubEventEntity?) {
        data.postValue(gitHub)
    }

}