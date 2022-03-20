package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable

@Suppress("UNCHECKED_CAST")
abstract class BaseViewRenderer<Item : BaseViewEntity,
        ViewHolder : BaseViewHolder<Item>,
        Listener : BaseListener>(val viewType: Int) {

    abstract fun createViewHolder(
        parent: ViewGroup,
        listener: Listener,
        compositeDisposable: CompositeDisposable,
        itemCount: Int
    ): RecyclerView.ViewHolder

    fun internalCreateViewHolder(
        parent: ViewGroup,
        listener: BaseListener,
        compositeDisposable: CompositeDisposable,
        itemCount: Int
    ): RecyclerView.ViewHolder {
        val castedListener = listener as? Listener
            ?: throw IllegalStateException("Type not valid of instance ${listener::class.simpleName}")
        return createViewHolder(parent, castedListener, compositeDisposable, itemCount)
    }

    fun internalBind(
        viewHolder: RecyclerView.ViewHolder,
        item: BaseViewEntity
    ) {
        val castedViewHolder = viewHolder as? ViewHolder
            ?: throw IllegalStateException("Type not valid of instance ${viewHolder::class.simpleName}")
        item as? Item
            ?: throw IllegalStateException("Type not valid of instance ${item::class.simpleName}")
        castedViewHolder.bind(item)
    }

}