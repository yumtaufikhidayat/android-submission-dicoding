package com.yumtaufikhidayat.gitser.ui.activity

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.local.FavoriteEntity
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.data.viewmodel.favorite.FavoriteViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivityFavoriteBinding
import com.yumtaufikhidayat.gitser.ui.adapter.SearchAdapter

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var searchAdapter: SearchAdapter
    private val favoriteViewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        checkThemes()
        initAdapter()
        checkOrientation()
        initObserver()
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            title = getString(R.string.tvFavorite)
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun initAdapter() {
        searchAdapter = SearchAdapter()
        binding.apply {
            with(rvFavorite) {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@FavoriteActivity)
                adapter = searchAdapter
            }
        }
    }

    private fun checkOrientation() = with(binding) {
        rvFavorite.layoutManager = if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            GridLayoutManager(this@FavoriteActivity, 2)
        } else {
            LinearLayoutManager(this@FavoriteActivity)
        }
    }

    private fun checkThemes() = with(binding){
        when (this@FavoriteActivity.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                layoutNoFavorite.tvNoDataTitle.setTextColor(ContextCompat.getColor(this@FavoriteActivity, R.color.white))
                layoutNoFavorite.tvNoDataDesc.setTextColor(ContextCompat.getColor(this@FavoriteActivity, R.color.white))
            }

            Configuration.UI_MODE_NIGHT_NO -> {
                layoutNoFavorite.tvNoDataTitle.setTextColor(ContextCompat.getColor(this@FavoriteActivity, R.color.black))
                layoutNoFavorite.tvNoDataDesc.setTextColor(ContextCompat.getColor(this@FavoriteActivity, R.color.black))
            }
        }
    }

    private fun initObserver() {
        favoriteViewModel.apply {
            getFavoriteUser()?.observe(this@FavoriteActivity) { listFavorite ->
                if (listFavorite != null) {
                    if (listFavorite.isNotEmpty()) {
                        val list = mapList(listFavorite)
                        searchAdapter.submitList(list)
                        showNoData(false)
                    } else {
                        showNoData(true)
                    }
                }
            }
        }
    }

    private fun mapList(users: List<FavoriteEntity>): ArrayList<Search> {
        val listOfUsers = ArrayList<Search>()
        for (user in users) {
            val userMapped = Search(
                user.id,
                user.login,
                user.avatarUrl,
                user.type
            )
            listOfUsers.add(userMapped)
        }

        return listOfUsers
    }

    private fun showNoData(isShow: Boolean) = with(binding) {
        if (isShow) {
            viewNoFavoriteVisibility.visibility = View.VISIBLE
            layoutNoFavorite.tvNoDataDesc.text = getString(R.string.tvNoFavorite)
            rvFavorite.visibility = View.GONE
        } else {
            viewNoFavoriteVisibility.visibility = View.GONE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}