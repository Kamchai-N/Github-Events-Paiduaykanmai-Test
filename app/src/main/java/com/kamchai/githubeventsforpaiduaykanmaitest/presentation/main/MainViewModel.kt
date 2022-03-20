package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main

import androidx.lifecycle.MutableLiveData
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview.BaseViewEntity
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.viewmodel.BaseViewModel
import com.kamchai.githubeventsforpaiduaykanmaitest.domain.usercase.GetGitHubEventUseCase
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.item_github_events.ItemGithubEventsViewEntity
import io.reactivex.rxkotlin.plusAssign
import timber.log.Timber
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getGitHubEventUseCase: GetGitHubEventUseCase
) : BaseViewModel() {

    val data = MutableLiveData<List<BaseViewEntity>>()

    init {
        getGitHubEvent()
    }

    private fun getGitHubEvent() {
        compositeDisposable += getGitHubEventUseCase.execute().map { map ->
            map.map { ItemGithubEventsViewEntity(it) }
        }.subscribe({
            data.postValue(it)
        }, {
            Timber.e(it.message ?: "ERROR_NO_MESSAGE")
        })
    }

}