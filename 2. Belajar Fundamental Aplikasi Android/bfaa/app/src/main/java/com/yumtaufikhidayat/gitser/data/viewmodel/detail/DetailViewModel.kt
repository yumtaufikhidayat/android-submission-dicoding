package com.yumtaufikhidayat.gitser.data.viewmodel.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.gitser.data.response.detail.DetailResponse
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

    companion object {
        private val TAG = DetailViewModel::class.java.simpleName
    }
}