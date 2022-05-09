package com.yumtaufikhidayat.gitser.data.viewmodel.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.network.ApiConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {

    private val apiConfig = ApiConfig.apiInstance
    private val listAllUsers = MutableLiveData<ArrayList<Search>>()

    fun setAllUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            apiConfig.getAllUsers().enqueue(object : Callback<ArrayList<Search>>{
                override fun onResponse(
                    call: Call<ArrayList<Search>>,
                    response: Response<ArrayList<Search>>
                ) {
                    if (response.isSuccessful) {
                        listAllUsers.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
        }
    }

    fun getAllUsers(): LiveData<ArrayList<Search>> {
        return listAllUsers
    }

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }
}