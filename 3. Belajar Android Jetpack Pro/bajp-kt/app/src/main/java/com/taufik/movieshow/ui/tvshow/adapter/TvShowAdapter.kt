package com.taufik.movieshow.ui.tvshow.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.taufik.movieshow.R
import com.taufik.movieshow.data.source.local.entity.TvShowEntity
import com.taufik.movieshow.databinding.ItemsMovieShowBinding
import com.taufik.movieshow.ui.tvshow.activity.DetailTvShowActivity
import com.taufik.movieshow.utils.Utils

class TvShowAdapter : PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowsViewHolder>(DIFF_CALLBACK) {

    class TvShowsViewHolder(private val binding: ItemsMovieShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowEntity: TvShowEntity) {
            with(binding) {
                Glide.with(itemView.context)
                        .load(Utils.IMAGE_URL + tvShowEntity.imagePoster)
                        .apply(
                                RequestOptions.placeholderOf(R.drawable.ic_loading)
                                        .error(R.drawable.ic_error)
                        )
                        .into(imgPoster)

                tvTitle.text = tvShowEntity.title
                tvReleaseDate.text = tvShowEntity.firstAirDate
                tvRating.text = tvShowEntity.rating.toString()

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvShowActivity::class.java).apply {
                        putExtra(DetailTvShowActivity.EXTRA_DETAIL, tvShowEntity)
                    }
                    it.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val itemsMovieShowBinding = ItemsMovieShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsMovieShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val pos = getItem(position)
        Log.e(TAG, "onBindViewHolder: $pos")
        if (pos != null) {
            holder.bind(pos)
        }
    }

    companion object {
        private const val TAG = "TV_SHOW_ADAPTER"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>(){
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                oldItem.tvShowId == newItem.tvShowId

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                oldItem == newItem
        }
    }
}