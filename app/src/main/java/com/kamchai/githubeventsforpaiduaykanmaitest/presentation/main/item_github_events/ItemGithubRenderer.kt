package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.item_github_events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview.BaseViewRenderer
import com.kamchai.githubeventsforpaiduaykanmaitest.databinding.ItemCardBinding
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.MainListener
import io.reactivex.disposables.CompositeDisposable

class ItemEmergencyViewRender : BaseViewRenderer<ItemGithubEventsViewEntity,
        ItemGitHubEventsViewHolder,
        MainListener>(1) {

    override fun createViewHolder(
        parent: ViewGroup,
        listener: MainListener,
        compositeDisposable: CompositeDisposable,
        itemCount: Int
    ): RecyclerView.ViewHolder = ItemGitHubEventsViewHolder(
        ItemCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ), compositeDisposable, listener
    )
}