package com.yumtaufikhidayat.gitser.data.viewmodel.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.data.response.search.SearchResponse
import com.yumtaufikhidayat.gitser.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val apiConfig = ApiConfig.apiInstance

    private val _listAllUsersData = MutableLiveData<ArrayList<Search>>()
    val listAllUsersData: LiveData<ArrayList<Search>> = _listAllUsersData

    fun setAllUsers() {
        apiConfig.getAllUsers().enqueue(object : Callback<ArrayList<Search>>{
            override fun onResponse(
                call: Call<ArrayList<Search>>,
                response: Response<ArrayList<Search>>
            ) {
                if (response.isSuccessful) {
                    _listAllUsersData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun setSearchUser(query: String) {
        apiConfig.searchUser(query).enqueue(object : Callback<SearchResponse>{
            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                if (response.isSuccessful) {
                    _listAllUsersData.postValue(response.body()?.items)
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }
}