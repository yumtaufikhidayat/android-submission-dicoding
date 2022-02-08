package com.taufik.gitser.activity.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.gitser.activity.data.User
import com.taufik.gitser.activity.data.UserData
import com.taufik.gitser.activity.ui.adapter.UserAdapter
import com.taufik.gitser.databinding.ActivityMainBinding

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