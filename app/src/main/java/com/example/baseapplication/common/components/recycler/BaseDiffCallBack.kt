package com.example.baseapplication.common.components.recycler

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffCallBack<T>(
    private val oldNumbers: List<T>,
    private val newNumbers: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldNumbers.size

    override fun getNewListSize(): Int = newNumbers.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNumbers[oldItemPosition] == newNumbers[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNumbers[oldItemPosition] == newNumbers[newItemPosition]
    }
}