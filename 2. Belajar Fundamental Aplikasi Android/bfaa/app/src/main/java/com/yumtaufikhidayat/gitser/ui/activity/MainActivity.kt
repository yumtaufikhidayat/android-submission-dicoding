package com.yumtaufikhidayat.gitser.ui.activity

import android.os.Bundle
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
    private var listUsers: ArrayList<User> = arrayListOf()

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
}