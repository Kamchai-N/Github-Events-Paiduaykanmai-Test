package com.kamchai.githubeventsforpaiduaykanmaitest.core.base.recyclerview

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable

class BaseAdapter(
    private val listener: BaseListener,
    private val disposable: CompositeDisposable,
    itemCallback: DiffUtil.ItemCallback<BaseViewEntity> = BaseDiffCallback
) : ListAdapter<BaseViewEntity, RecyclerView.ViewHolder>(itemCallback) {

    private val viewRenderers =
        SparseArray<BaseViewRenderer<out BaseViewEntity, out BaseViewHolder<out BaseViewEntity>, out BaseListener>>()

    fun registerRenderer(renderer: BaseViewRenderer<out BaseViewEntity, out BaseViewHolder<out BaseViewEntity>, out BaseListener>) {
        if (viewRenderers[renderer.viewType] == null) {
            viewRenderers[renderer.viewType] = renderer
        } else {
            throw IllegalStateException("ViewRenderer type ${renderer::class.simpleName} was already added!")
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (itemCount > 0) getItem(position).viewType() else -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        viewRenderers[viewType].internalCreateViewHolder(parent, listener, disposable, itemCount)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position in (0 until itemCount)) {
            val item = getItem(position)
            viewRenderers[item.viewType()].internalBind(holder, item)
        }
    }

}