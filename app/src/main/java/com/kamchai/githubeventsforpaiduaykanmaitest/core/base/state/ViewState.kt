package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.state

abstract class ViewState {

    class Normal : ViewState()

    class Loading : ViewState()

    class Success(
        val message: String = String(),
        val dismissAction: () -> Unit = {},
        val title: String? = null
    ) : ViewState()
}