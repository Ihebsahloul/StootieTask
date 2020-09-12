package com.android.kotlinrecyclerviewpagination.ui.adapters.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

open class BaseVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val context: Context = itemView.context

    protected fun getContext(): Context {
        return context
    }
}