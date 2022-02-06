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
import com.taufik.movieshow.ui.movie.adapter.FavoriteMovieAdapter
import com.taufik.movieshow.ui.tvshow.activity.DetailTvShowActivity
import com.taufik.movieshow.utils.Utils

class FavoriteTvShowAdapter : PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.TvShowViewHolder>(DIFF_CALLBACK){
    
    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition) 
    
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteTvShowAdapter.TvShowViewHolder {
        val view = ItemsMovieShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowAdapter.TvShowViewHolder, position: Int) {
        val pos = getItem(position)
        if (pos != null) {
            holder.bind(pos)
        }
    }

    inner class TvShowViewHolder(private val binding: ItemsMovieShowBinding) :
        RecyclerView.ViewHolder(binding.root) {
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
                        Log.e(FavoriteMovieAdapter.TAG, "bind: $tvShowEntity")
                        putExtra(DetailTvShowActivity.EXTRA_DETAIL, tvShowEntity)
                    }
                    it.context.startActivity(intent)
                }
            }
        }
    }

    companion object {
        const val TAG = "FAVORITE_TV_SHOW_ADPTER"
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>(){
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                oldItem.tvShowId == newItem.tvShowId

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                oldItem == newItem
        }
    }
}