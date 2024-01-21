package com.example.baseapplication.common.components.recycler

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T : ViewBinding>(
    val binding: T
) : RecyclerView.ViewHolder(binding.root)