package com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.item_github_events

import android.graphics.Typeface
import com.kamchai.githubeventsforpaiduaykanmaitest.R
import com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview.BaseViewHolder
import com.kamchai.githubeventsforpaiduaykanmaitest.core.di.GlideApp
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.context
import com.kamchai.githubeventsforpaiduaykanmaitest.core.extension.onClick
import com.kamchai.githubeventsforpaiduaykanmaitest.databinding.ItemCardBinding
import com.kamchai.githubeventsforpaiduaykanmaitest.presentation.main.MainListener
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign

class ItemGitHubEventsViewHolder(
    private val binding: ItemCardBinding,
    private val compositeDisposable: CompositeDisposable,
    private val listener: MainListener
) : BaseViewHolder<ItemGithubEventsViewEntity>(binding.root) {

    override var currentItem = ItemGithubEventsViewEntity()

    init {
        compositeDisposable += binding.root.onClick {
            listener.onItemClicked(currentItem.gitHub)
        }
    }

    override fun bind(item: ItemGithubEventsViewEntity) {
        currentItem = item
        binding.tvName.text = currentItem.gitHub.displayLogin
        binding.tvType.text = currentItem.gitHub.type
        GlideApp.with(context())
            .load(currentItem.gitHub.avatarUrl)
            .error(R.drawable.ic_avarta)
            .into(binding.ivAvatar)
    }
}