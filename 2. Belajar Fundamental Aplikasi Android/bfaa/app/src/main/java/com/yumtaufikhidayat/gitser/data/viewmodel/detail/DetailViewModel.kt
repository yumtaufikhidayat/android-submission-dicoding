package com.yumtaufikhidayat.gitser.data.viewmodel.detail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.local.FavoriteDao
import com.yumtaufikhidayat.gitser.data.local.FavoriteEntity
import com.yumtaufikhidayat.gitser.data.local.UserDatabase
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

class DetailViewModel(application: Application): AndroidViewModel(application) {

    private val apiConfig = ApiConfig.apiInstance

    private val _detailInfoData = MutableLiveData<DetailResponse>()
    val detailInfoData: LiveData<DetailResponse> = _detailInfoData

    private val _listOfFollowingData = MutableLiveData<ArrayList<Search>>()
    val listOfFollowingData: LiveData<ArrayList<Search>> = _listOfFollowingData

    private val _listOfFollowersData = MutableLiveData<ArrayList<Search>>()
    val listOfFollowersData: LiveData<ArrayList<Search>> = _listOfFollowersData

    private val _listOfRepositoriesData = MutableLiveData<ArrayList<RepositoryResponse>>()
    val listOfRepositoriesData: LiveData<ArrayList<RepositoryResponse>> = _listOfRepositoriesData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _snackBarText = MutableLiveData<String>()
    val snackBarText: LiveData<String> = _snackBarText

    private var userDao: FavoriteDao?
    private var userDb: UserDatabase? = UserDatabase.getDatabase(application)

    init {
        userDao = userDb?.favoriteUserDao()
    }

    fun setDetailData(username: String) {
        _isLoading.value = true
        apiConfig.getDetailUser(username)
            .enqueue(object : Callback<DetailResponse>{
                override fun onResponse(
                    call: Call<DetailResponse>,
                    response: Response<DetailResponse>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _detailInfoData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                    _isLoading.value = false
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun setListOfFollowing(username: String) {
        _isLoading.value = true
        apiConfig.getFollowingUsers(username)
            .enqueue(object : Callback<ArrayList<Search>>{
                override fun onResponse(
                    call: Call<ArrayList<Search>>,
                    response: Response<ArrayList<Search>>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _listOfFollowingData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                    _isLoading.value = false
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun setListOfFollower(username: String) {
        _isLoading.value = true
        apiConfig.getFollowerUsers(username)
            .enqueue(object : Callback<ArrayList<Search>>{
                override fun onResponse(
                    call: Call<ArrayList<Search>>,
                    response: Response<ArrayList<Search>>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _listOfFollowersData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<Search>>, t: Throwable) {
                    _isLoading.value = false
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun setListOfRepositories(username: String) {
        _isLoading.value = true
        apiConfig.getRepositories(username)
            .enqueue(object : Callback<ArrayList<RepositoryResponse>>{
                override fun onResponse(
                    call: Call<ArrayList<RepositoryResponse>>,
                    response: Response<ArrayList<RepositoryResponse>>
                ) {
                    _isLoading.value = false
                    if (response.isSuccessful) {
                        _listOfRepositoriesData.postValue(response.body())
                    }
                }

                override fun onFailure(
                    call: Call<ArrayList<RepositoryResponse>>,
                    t: Throwable
                ) {
                    _isLoading.value = false
                    Log.e(TAG, "onFailure: ${t.message}")
                }
            })
    }

    fun addToFavorite(id: Int, username: String, avatarUrl: String, type: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user = FavoriteEntity(
                id, username, avatarUrl, type
            )

            userDao?.addUserToFavorite(user)
        }
        _snackBarText.value = getApplication<Application?>().resources.getString(R.string.tvAddedToFavorite)
    }

    suspend fun checkUserFavorite(id: Int) = userDao?.checkUserFavorite(id)

    fun removeFromFavorite(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao?.removeUserFromFavorite(id)
        }
        _snackBarText.value = getApplication<Application?>().resources.getString(R.string.tvRemovedFromFavorite)
    }

    companion object {
        private val TAG = DetailViewModel::class.java.simpleName
    }
}