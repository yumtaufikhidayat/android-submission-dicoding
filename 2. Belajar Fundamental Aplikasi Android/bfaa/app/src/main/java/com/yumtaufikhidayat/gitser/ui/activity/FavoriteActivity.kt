package com.yumtaufikhidayat.gitser.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.data.local.FavoriteEntity
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.data.viewmodel.favorite.FavoriteViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivityFavoriteBinding
import com.yumtaufikhidayat.gitser.ui.adapter.SearchAdapter

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var searchdapter: SearchAdapter
    private val favoriteViewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        setAdapter()
        initObserver()
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            title = "Favorit"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setAdapter() {
        searchdapter = SearchAdapter()
        binding.apply {
            with(rvFavorite) {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@FavoriteActivity)
                adapter = searchdapter
            }
        }
    }

    private fun initObserver() {
        favoriteViewModel.getFavoriteUser()?.observe(this) {
            if (it != null) {
                val list = mapList(it)
                searchdapter.submitList(list)
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}