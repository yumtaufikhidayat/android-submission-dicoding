package com.yumtaufikhidayat.gitser.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.viewmodel.main.MainViewModel
import com.yumtaufikhidayat.gitser.data.viewmodel.settings.SettingsViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivityMainBinding
import com.yumtaufikhidayat.gitser.databinding.ActivitySettingsBinding
import com.yumtaufikhidayat.gitser.settings.SettingPreferences
import com.yumtaufikhidayat.gitser.ui.adapter.SearchAdapter
import com.yumtaufikhidayat.gitser.utils.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingSetting: ActivitySettingsBinding
    private lateinit var searchAdapter: SearchAdapter

    private val mainViewModel: MainViewModel by viewModels()
    private val delayMillis = 1000L
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTheme()
        initView()
        showListUsers()
    }

    private fun initTheme() {
        bindingSetting = ActivitySettingsBinding.inflate(layoutInflater)
        bindingSetting.apply {
            val pref = SettingPreferences.getInstance(dataStore)
            val settingViewModel = ViewModelProvider(this@MainActivity, ViewModelFactory(pref))[SettingsViewModel::class.java]
            settingViewModel.getThemeSetting().observe(this@MainActivity) {
                if (it) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    swTheme.isChecked = true
                    swTheme.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    swTheme.isChecked = false
                }
            }

            swTheme.setOnCheckedChangeListener { _: CompoundButton?, isChecked ->
                settingViewModel.saveThemeSetting(isChecked)
            }
        }
    }

    private fun initView() {
        searchAdapter = SearchAdapter()
        binding.apply {
            with(rvMain) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
                adapter = searchAdapter
            }
        }
    }

    private fun showListUsers() {
        showLoading(true)
        mainViewModel.apply {
            setAllUsers()
            getAllUsers().observe(this@MainActivity) {
                if (it != null) {
                    searchAdapter.submitList(it)
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(isShow: Boolean) = with(binding){
        if (isShow) {
            shimmerLoadingMain.visibility = View.VISIBLE
            rvMain.visibility = View.GONE
        } else {
            shimmerLoadingMain.visibility = View.GONE
            rvMain.visibility = View.VISIBLE
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_search_main -> startActivity(Intent(this, SearchActivity::class.java))
            R.id.nav_settings -> startActivity(Intent(this, SettingsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        doubleBackToExitPressedOnce = true
        Toast.makeText(this, getString(R.string.tvClickAgainToExit), Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper())
            .postDelayed({
                doubleBackToExitPressedOnce = false
            }, delayMillis)
    }
}