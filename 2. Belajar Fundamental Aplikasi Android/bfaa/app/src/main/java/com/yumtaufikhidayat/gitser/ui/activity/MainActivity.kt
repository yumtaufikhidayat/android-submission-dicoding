package com.yumtaufikhidayat.gitser.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.data.viewmodel.main.MainViewModel
import com.yumtaufikhidayat.gitser.databinding.ActivityMainBinding
import com.yumtaufikhidayat.gitser.ui.adapter.UserAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val mainViewModel: MainViewModel by viewModels()
    private val delayMillis = 1000L
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showListUsers()
    }

    private fun showListUsers() {
        binding.apply {
            showLoading(true)
            userAdapter = UserAdapter()
            with(rvMain) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                setHasFixedSize(true)
                adapter = userAdapter
            }

            mainViewModel.apply {
                setAllUsers()
                getAllUsers().observe(this@MainActivity) {
                    if (it != null) {
                        userAdapter.setSearchUserList(it)
                        showLoading(false)
                    }
                }
            }
        }
    }

    private fun showLoading(isShow: Boolean) {
        binding.apply {
            if (isShow) {
                shimmerLoadingMain.visibility = View.VISIBLE
                rvMain.visibility = View.GONE
            } else {
                shimmerLoadingMain.visibility = View.GONE
                rvMain.visibility = View.VISIBLE
            }
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Klik sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper())
            .postDelayed({
                doubleBackToExitPressedOnce = false
            }, delayMillis)
    }
}