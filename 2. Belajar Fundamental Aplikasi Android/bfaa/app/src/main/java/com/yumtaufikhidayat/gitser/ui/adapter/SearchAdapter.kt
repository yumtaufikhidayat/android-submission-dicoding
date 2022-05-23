package com.yumtaufikhidayat.gitser.ui.adapter

import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.databinding.ItemListUserBinding
import com.yumtaufikhidayat.gitser.ui.activity.DetailActivity
import com.yumtaufikhidayat.gitser.utils.Utils.loadImage

class SearchAdapter: ListAdapter<Search, SearchAdapter.SearchViewHolder>(SearchDiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.SearchViewHolder {
        return SearchViewHolder(
            ItemListUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(
        holder: SearchAdapter.SearchViewHolder,
        position: Int
    ) = holder.onBind(getItem(position))

    inner class SearchViewHolder(private val binding: ItemListUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Search) = with(binding) {
            imgProfilePhoto.loadImage(item.avatarUrl)
            tvUsername.text = item.login
            tvProfileType.text = item.type

            when (itemView.context.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    tvUsername.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
                    tvProfileType.setTextColor(ContextCompat.getColor(itemView.context, R.color.white))
                }

                Configuration.UI_MODE_NIGHT_NO -> {
                    tvUsername.setTextColor(ContextCompat.getColor(itemView.context, R.color.black))
                    tvProfileType.setTextColor(ContextCompat.getColor(itemView.context, R.color.black))
                }

                Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                    tvUsername.setTextColor(ContextCompat.getColor(itemView.context, R.color.black))
                    tvProfileType.setTextColor(ContextCompat.getColor(itemView.context, R.color.black))
                }
            }

            constraintItemUser.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.EXTRA_PARCELABLE, item)
                }
                it.context.startActivity(intent)
            }
        }
    }

    object SearchDiffCallback: DiffUtil.ItemCallback<Search>(){
        override fun areItemsTheSame(
            oldItem: Search,
            newItem: Search
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Search,
            newItem: Search
        ): Boolean = oldItem == newItem
    }
}