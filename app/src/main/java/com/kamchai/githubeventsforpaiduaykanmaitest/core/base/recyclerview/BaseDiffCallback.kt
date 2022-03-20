package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview

import androidx.recyclerview.widget.DiffUtil

object BaseDiffCallback : DiffUtil.ItemCallback<BaseViewEntity>() {

    override fun areItemsTheSame(
        oldItem: BaseViewEntity,
        newItem: BaseViewEntity
    ): Boolean = oldItem.viewType() == newItem.viewType()

    override fun areContentsTheSame(
        oldItem: BaseViewEntity,
        newItem: BaseViewEntity
    ): Boolean = false

}