package com.taufik.movieshow.ui.movie.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.taufik.movieshow.R
import com.taufik.movieshow.data.source.local.entity.MovieEntity
import com.taufik.movieshow.databinding.ActivityDetailMovieBinding
import com.taufik.movieshow.ui.activity.ViewModelFactory
import com.taufik.movieshow.ui.movie.adapter.DetailMovieAdapter
import com.taufik.movieshow.ui.movie.viewmodel.DetailMovieViewModel
import com.taufik.movieshow.utils.Utils
import com.taufik.movieshow.vo.Status

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel
    private lateinit var parcelData: MovieEntity
    private lateinit var data: MovieEntity
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setParcelableData()

        initActionBar()

        setData()

        setReadMore()
    }

    private fun setParcelableData() {
        parcelData = intent.getParcelableExtra(EXTRA_DETAIL)!!
        Log.e(TAG, "setParcelableData: $parcelData")
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setIcon(R.drawable.ic_arrow_back)
            elevation = 0F
            title = parcelData.title
        }
    }

    private fun setData() {
        val movieId = parcelData.movieId
        val factory = ViewModelFactory.getInstance(this)
        val detailMovieAdapter = DetailMovieAdapter()
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]
        viewModel.setSelectedMovie(movieId)

        binding.apply {
            progressBarMovie.visibility = View.VISIBLE
            viewModel.otherMovies.observe(this@DetailMovieActivity, {
                if (it != null) {
                    when (it.status) {
                        Status.LOADING -> {
                            Log.e(TAG, "setData: $it")
                            progressBarMovie.visibility = View.VISIBLE
                        }

                        Status.SUCCESS -> {
                            if (it.data != null) {
                                progressBarMovie.visibility = View.GONE
                                Log.e(TAG, "setData: ${it.data.mOtherMovies}")
                                detailMovieAdapter.setOtherMovies(it.data.mOtherMovies)
                                populateDetailMovie(it.data.mMovie)
                            }
                        }
                        
                        Status.ERROR -> {
                            progressBarMovie.visibility = View.GONE
                            Log.e(TAG, "setData: $it")
                            Toast.makeText(
                                this@DetailMovieActivity, 
                                "Terjadi kesalahan", 
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })
        }

        with(binding.rvTopMovieShow) { 
            isNestedScrollingEnabled = false
            layoutManager = LinearLayoutManager(this@DetailMovieActivity, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = detailMovieAdapter
        }
    }

    private fun setReadMore() {
        binding.apply {
            tvMovieReadMore.visibility = View.VISIBLE
            tvMovieReadMore.setOnClickListener {
                if (tvMovieReadMore.text.toString() == "Read More") {
                    tvMovieOverview.maxLines = Integer.MAX_VALUE
                    tvMovieOverview.ellipsize = null
                    tvMovieReadMore.text = getString(R.string.tvReadLess)
                } else {
                    tvMovieOverview.maxLines = 4
                    tvMovieOverview.ellipsize = TextUtils.TruncateAt.END
                    tvMovieReadMore.text = getString(R.string.tvReadMore)
                }
            }
        }
    }

    private fun populateDetailMovie(movieEntity: MovieEntity) {
        binding.apply {

            data = movieEntity

            imgMovieBackdrop.loadImage(movieEntity.imageBackdrop)
            imgMoviePoster.loadImage(movieEntity.imagePoster)
            tvMovieTitle.text = movieEntity.title
            tvMovieReleaseDate.text = movieEntity.releaseDate
            tvMovieOverview.text = movieEntity.overview
            tvMovieRating.text = movieEntity.rating.toString()
            tvMovieLanguage.text = movieEntity.language
        }
    }

    private fun ImageView.loadImage(url: String) {
        Glide.with(this.context)
            .load(Utils.IMAGE_URL + url)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error)
            )
            .into(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        this.menu = menu
        binding.apply {
            viewModel.otherMovies.observe(this@DetailMovieActivity, {
                if (it != null) {
                    when (it.status) {
                        Status.LOADING -> progressBarMovie.visibility = View.VISIBLE

                        Status.SUCCESS -> {
                            if (it.data != null) {
                                progressBarMovie.visibility = View.GONE
                                val state = it.data.mMovie.favorited
                                setFavorite(state)
                                Log.e(TAG, "onCreateOptionsMenu: $state")
                            }
                        }

                        Status.ERROR -> {
                            progressBarMovie.visibility = View.GONE
                            Toast.makeText(
                                this@DetailMovieActivity,
                                "Terjadi kesalahan",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            })
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {

            android.R.id.home -> onBackPressed()

            R.id.action_favorite -> {
                viewModel.setFavorite()
                return true
            }

            R.id.action_share -> {
                try {

                    val body = "Visit this awesome movie \n${data.homePage}"

                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, body)
                    startActivity(Intent.createChooser(shareIntent, "Share with:"))
                } catch (e: Exception) {
                    Log.e("shareFailed", "onOptionsItemSelected: ${e.localizedMessage}")
                }
            }

            R.id.action_open_in_browser -> {
                try {
                    val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(data.homePage))
                    startActivity(Intent.createChooser(intentBrowser, "Open with:"))
                } catch (e: java.lang.Exception) {
                    Log.e("errorIntent", "onBindViewHolder: ${e.localizedMessage}")
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setFavorite(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_detail)
        }
    }

    companion object {
        const val EXTRA_DETAIL = "com.taufik.movieshow.ui.movie.activity.EXTRA_DETAIL"
        const val TAG = "DETAIL_MOVIE_ACTIVITY"
    }
}