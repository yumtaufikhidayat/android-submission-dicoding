package com.yumtaufikhidayat.gitser.data.viewmodel.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.gitser.data.response.detail.DetailResponse
import com.yumtaufikhidayat.gitser.data.response.detail.RepositoryResponse
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {

    private val apiConfig = ApiConfig.apiInstance

    private val _detailInfoData = MutableLiveData<DetailResponse>()
    val detailInfoData: LiveData<DetailResponse> = _detailInfoData

    private val _listOfFollowingData = MutableLiveData<ArrayList<Search>>()
    val listOfFollowingData: LiveData<ArrayList<Search>> = _listOfFollowingData

    private val _listOfFollowersData = MutableLiveData<ArrayList<Search>>()
    val listOfFollowersData: LiveData<ArrayList<Search>> = _listOfFollowersData

    private val _listOfRepositoriesData = MutableLiveData<ArrayList<RepositoryResponse>>()
    val listOfRepositoriesData: LiveData<ArrayList<RepositoryResponse>> = _listOfRepositoriesData

    fun setDetailData(username: String) {
        apiConfig.getDetailUser(username)
            .enqueue(object : Callback<DetailResponse>{
                override fun onResponse(
                    call: Call<DetailResponse>,
                    response: Response<DetailResponse>
                ) {
                    if (response.isSuccessful) {
                        _detailInfoData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun setListOfFollowing(username: String) {
        apiConfig.getFollowingUsers(username)
            .enqueue(object : Callback<ArrayList<Search>>{
                override fun onResponse(
                    call: Call<ArrayList<Search>>,
                    response: Response<ArrayList<Search>>
                ) {
                    if (response.isSuccessful) {
                        _listOfFollowingData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun setListOfFollower(username: String) {
        apiConfig.getFollowerUsers(username)
            .enqueue(object : Callback<ArrayList<Search>>{
                override fun onResponse(
                    call: Call<ArrayList<Search>>,
                    response: Response<ArrayList<Search>>
                ) {
                    if (response.isSuccessful) {
                        _listOfFollowersData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun setListOfRepositories(username: String) {
        apiConfig.getRepositories(username)
            .enqueue(object : Callback<ArrayList<RepositoryResponse>>{
                override fun onResponse(
                    call: Call<ArrayList<RepositoryResponse>>,
                    response: Response<ArrayList<RepositoryResponse>>
                ) {
                    if (response.isSuccessful) {
                        _listOfRepositoriesData.postValue(response.body())
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

    companion object {
        private val TAG = DetailViewModel::class.java.simpleName
    }
}