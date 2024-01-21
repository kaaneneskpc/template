package com.example.baseapplication.common.components.recycler.test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseapplication.common.components.recycler.BaseRecyclerAdapter
import com.example.baseapplication.common.components.recycler.BaseViewHolder
import com.example.baseapplication.core.data.repo.testRepo.data.response.TestResponse
/*
class TestAdapter : BaseRecyclerAdapter<TestResponse>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return RandomUserViewHolder(parent, inflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RandomUserViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    inner class RandomUserViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater
    ) : BaseViewHolder<LayoutTestBinding>(
        binding = LayoutTestBinding.inflate(inflater, parent, false)
    ) {
        fun bind(item: TestResponse) {
            binding.testText.text = item.test
        }
    }
}
*/