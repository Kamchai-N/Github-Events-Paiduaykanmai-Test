package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<Item : BaseViewEntity>(view: View) :
    RecyclerView.ViewHolder(view) {

    abstract var currentItem: Item

    abstract fun bind(item: Item)

}