package com.example.baseapplication.common.components.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items = listOf<T>()

    fun updateData(newItems: List<T>) {
        val diffCallBack = BaseDiffCallBack(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallBack)
        diffResult.dispatchUpdatesTo(this)
        items = newItems
    }

    fun updateDataNotify(newItems: List<T>) {
        items = newItems
        notifyDataSetChanged()
    }

    abstract fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        onCreateViewHolder(
            parent = parent,
            inflater = LayoutInflater.from(parent.context),
            viewType = viewType
        )

    override fun getItemCount(): Int = items.size
}