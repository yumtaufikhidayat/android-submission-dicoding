package com.yumtaufikhidayat.gitser.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.data.User
import com.yumtaufikhidayat.gitser.data.UserData
import com.yumtaufikhidayat.gitser.databinding.ActivityMainBinding
import com.yumtaufikhidayat.gitser.ui.adapter.UserAdapter
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val delayMillis = 1000L
    private var listUsers: ArrayList<User> = arrayListOf()
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showListUsers()
    }

    private fun showListUsers() {
        listUsers.addAll(UserData.listUserData)
        userAdapter = UserAdapter(listUsers)
        binding.apply {
            with(rvMain) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = userAdapter
            }
        }
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Klik sekali lagi untuk keluar", Toast.LENGTH_SHORT).show()

        Handler(Looper.getMainLooper())
            .postDelayed({
                doubleBackToExitPressedOnce = false
            }, delayMillis)
    }
}