package com.kelompok6.penjadwalan.ui.activity.penjadwalan

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.kelompok6.penjadwalan.api.ApiConfig
import com.kelompok6.penjadwalan.model.AddScheduleResponse
import com.kelompok6.penjadwalan.model.GetScheduleResponse
import com.kelompok6.penjadwalan.model.GetScheduleResponseItem
import com.kelompok6.penjadwalan.model.User
import com.kelompok6.penjadwalan.other.UserPreferences
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchedulingViewModel(private val pref: UserPreferences ) : ViewModel()  {

    val listSchedule = MutableLiveData<ArrayList<GetScheduleResponseItem>>()

    fun setSchedule(callback: () -> Unit){
        val client = ApiConfig.getApiService().getSchedule()
        client.enqueue(object : Callback<GetScheduleResponse>{
            override fun onResponse(
                call: Call<GetScheduleResponse>,
                response: Response<GetScheduleResponse>,
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){
                        listSchedule.postValue(responseBody!!.data)
                    }
                    callback.invoke()
                }
            }

            override fun onFailure(call: Call<GetScheduleResponse>, t: Throwable) {
                Log.d( "Failure", t.message.toString())
            }
        })
    }

    fun getSchedule(): LiveData<ArrayList<GetScheduleResponseItem>>{
        return listSchedule
    }

}