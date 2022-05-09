package com.yumtaufikhidayat.gitser.data.viewmodel.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.gitser.data.response.detail.DetailResponse
import com.yumtaufikhidayat.gitser.data.response.detail.RepositoryResponse
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.network.ApiConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {

    private val apiConfig = ApiConfig.apiInstance
    private val detailData = MutableLiveData<DetailResponse>()
    private val listOfFollowing = MutableLiveData<ArrayList<Search>>()
    private val listOfFollowers = MutableLiveData<ArrayList<Search>>()
    private val listOfRepositories = MutableLiveData<ArrayList<RepositoryResponse>>()

    fun setDetailData(username: String) {
        CoroutineScope(Dispatchers.IO).launch {
            apiConfig.getDetailUser(username)
                .enqueue(object : Callback<DetailResponse>{
                    override fun onResponse(
                        call: Call<DetailResponse>,
                        response: Response<DetailResponse>
                    ) {
                        if (response.isSuccessful) {
                            detailData.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                        Log.d(TAG, "onFailure: ${t.message}")
                    }
                })
        }
    }

    fun getDetailData(): LiveData<DetailResponse> = detailData

    fun setListOfFollowing(username: String) {
        CoroutineScope(Dispatchers.IO).launch {
            apiConfig.getFollowingUsers(username)
                .enqueue(object : Callback<ArrayList<Search>>{
                    override fun onResponse(
                        call: Call<ArrayList<Search>>,
                        response: Response<ArrayList<Search>>
                    ) {
                        if (response.isSuccessful) {
                            listOfFollowing.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                        Log.e(TAG, "onFailure: ${t.message}")
                    }
                })
        }
    }

    fun getListOfFollowing(): LiveData<ArrayList<Search>> = listOfFollowing

    fun setListOfFollower(username: String) {
        CoroutineScope(Dispatchers.IO).launch {
            apiConfig.getFollowerUsers(username)
                .enqueue(object : Callback<ArrayList<Search>>{
                    override fun onResponse(
                        call: Call<ArrayList<Search>>,
                        response: Response<ArrayList<Search>>
                    ) {
                        if (response.isSuccessful) {
                            listOfFollowers.postValue(response.body())
                        }
                    }

                    override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                        Log.e(TAG, "onFailure: ${t.message}")
                    }
                })
        }
    }

    fun getListOfFollower(): LiveData<ArrayList<Search>> = listOfFollowers

    fun setListOfRepositories(username: String) {
        CoroutineScope(Dispatchers.IO).launch {
            apiConfig.getRepositories(username)
                .enqueue(object : Callback<ArrayList<RepositoryResponse>>{
                    override fun onResponse(
                        call: Call<ArrayList<RepositoryResponse>>,
                        response: Response<ArrayList<RepositoryResponse>>
                    ) {
                        if (response.isSuccessful) {
                            listOfRepositories.postValue(response.body())
                        }
                    }

                    override fun onFailure(
                        call: Call<ArrayList<RepositoryResponse>>,
                        t: Throwable
                    ) {
                        Log.e(TAG, "onFailure: ${t.message}")
                    }
                })
        }
    }

    fun getListOfRepositories(): LiveData<ArrayList<RepositoryResponse>> = listOfRepositories

    companion object {
        private val TAG = DetailViewModel::class.java.simpleName
    }
}