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

    private val _listAllSearchUsersData = MutableLiveData<ArrayList<Search>>()
    val listAllSearchUsersData: LiveData<ArrayList<Search>> = _listAllSearchUsersData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        setAllUsers()
    }

    private fun setAllUsers() {
        _isLoading.value = true
        apiConfig.getAllUsers()
            .enqueue(object : Callback<ArrayList<Search>>{
                override fun onResponse(
                    call: Call<ArrayList<Search>>,
                    response: Response<ArrayList<Search>>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _listAllUsersData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                    _isLoading.value = false
                    Log.e(TAG, "onFailure: ${t.message}")
                }
        })
    }

    fun setSearchUser(query: String) {
        _isLoading.value = true
        apiConfig.searchUser(query)
            .enqueue(object : Callback<SearchResponse>{
                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _listAllSearchUsersData.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    _isLoading.value = false
                    Log.e(TAG, "onFailure: ${t.message}")
                }
        })
    }

    companion object {
        private val TAG = MainViewModel::class.java.simpleName
    }
}