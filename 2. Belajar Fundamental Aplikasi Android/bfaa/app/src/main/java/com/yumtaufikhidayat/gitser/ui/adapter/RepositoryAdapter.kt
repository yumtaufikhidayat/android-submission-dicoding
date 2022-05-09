package com.yumtaufikhidayat.gitser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.gitser.data.response.detail.RepositoryResponse
import com.yumtaufikhidayat.gitser.databinding.ItemListRepositoryBinding
import kotlin.math.roundToInt

class RepositoryAdapter: ListAdapter<RepositoryResponse, RepositoryAdapter.RepositoryViewHolder>(RepositoryDiffCalback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RepositoryAdapter.RepositoryViewHolder {
        return RepositoryViewHolder(
            ItemListRepositoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: RepositoryAdapter.RepositoryViewHolder,
        position: Int
    ) = holder.onBind(getItem(position))

    inner class RepositoryViewHolder(private val binding: ItemListRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: RepositoryResponse) = with(binding){
            tvRepositoryName.text = item.name
            tvRepositoryDesc.text = item.description
            tvRepositorySize.text = item.size.toString()
            tvRepositoryLanguage.text = item.language

            val repoSize = item.size
            tvRepositorySize.text = repoSize.toString()

            val sizeStr = tvRepositorySize.text.toString().trim()
            val sizeInt = sizeStr.toInt()
            val sizeDouble = sizeInt / 1000.toFloat()
            val sizeIntNew = sizeDouble.roundToInt()

            if (sizeIntNew < 1) {
                val sizeDoubleKb = (sizeDouble * 1000).roundToInt()
                val sizeIntKb = sizeDoubleKb.toDouble().roundToInt()
                tvRepositorySize.text = String.format("%s KB", sizeIntKb)
            } else {
                tvRepositorySize.text = String.format("%s MB", sizeIntNew)
            }
        }
    }

    object RepositoryDiffCalback: DiffUtil.ItemCallback<RepositoryResponse>(){
        override fun areItemsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean = oldItem == newItem
    }
}