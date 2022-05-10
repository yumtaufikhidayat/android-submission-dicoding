package com.yumtaufikhidayat.gitser.ui.adapter

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.gitser.data.response.detail.RepositoryResponse
import com.yumtaufikhidayat.gitser.databinding.ItemListRepositoryBinding
import kotlin.math.roundToInt

class RepositoryAdapter: ListAdapter<RepositoryResponse, RepositoryAdapter.RepositoryViewHolder>(RepositoryDiffCallback) {
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

            itemView.setOnClickListener {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.htmlUrl))
                    itemView.context.startActivity(Intent.createChooser(intent, "Open with:"))
                } catch (e: Exception) {
                    Log.e(TAG, "onBindViewHolder: ${e.message}")
                }
            }
        }
    }

    object RepositoryDiffCallback: DiffUtil.ItemCallback<RepositoryResponse>(){
        override fun areItemsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: RepositoryResponse,
            newItem: RepositoryResponse
        ): Boolean = oldItem == newItem
    }

    companion object {
        private val TAG = RepositoryAdapter::class.java.simpleName
    }
}