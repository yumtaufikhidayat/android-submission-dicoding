package com.yumtaufikhidayat.gitser.ui.activity

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.viewmodel.main.MainViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivitySearchBinding
import com.yumtaufikhidayat.gitser.ui.adapter.SearchAdapter

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var searchAdapter: SearchAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()
        initView()
        initObserver()
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            title = "Cari"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun initView() {
        searchAdapter = SearchAdapter()
        binding.apply {
            with(rvSearchUsers) {
                layoutManager = LinearLayoutManager(this@SearchActivity)
                setHasFixedSize(true)
                adapter = searchAdapter
            }
        }
    }

    private fun initObserver() {
        mainViewModel.apply {
            listAllSearchUsersData.observe(this@SearchActivity) {
                searchAdapter.submitList(it)
            }

            isLoading.observe(this@SearchActivity) {
                showLoading(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            queryHint = resources.getString(R.string.tvSearchUser)
            setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    when {
                        query.isNotEmpty() -> {
                            mainViewModel.setSearchUser(query)
                            clearFocus()
                        }

                        query.isEmpty() -> {
                            Toast.makeText(this@SearchActivity, getString(R.string.tvPleaseFillForm), Toast.LENGTH_SHORT).show()
                            clearFocus()
                        }
                    }

                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
        }
        return true
    }

    private fun showLoading(isShow: Boolean) = with(binding) {
        if (isShow) {
            shimmerLoadingSearch.visibility = View.VISIBLE
            rvSearchUsers.visibility = View.GONE
        } else {
            shimmerLoadingSearch.visibility = View.GONE
            rvSearchUsers.visibility = View.VISIBLE
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}