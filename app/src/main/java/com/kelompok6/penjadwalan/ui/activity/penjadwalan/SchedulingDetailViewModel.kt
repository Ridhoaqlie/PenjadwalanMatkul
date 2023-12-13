package com.kelompok6.penjadwalan.ui.activity.penjadwalan

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kelompok6.penjadwalan.api.ApiConfig
import com.kelompok6.penjadwalan.model.DeleteScheduleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchedulingDetailViewModel: ViewModel() {

    fun deleteCourse(idSchedule: String, callback: ()->Unit){
        val client = ApiConfig.getApiService().deleteSchedule(idSchedule)
        client.enqueue(object : Callback<DeleteScheduleResponse> {
            override fun onResponse(
                call: Call<DeleteScheduleResponse>,
                response: Response<DeleteScheduleResponse>,
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()
                    if (responseBody != null){

                    }
                    Log.d( "Success", response.message().toString())
                    callback.invoke()
                }
            }

            override fun onFailure(call: Call<DeleteScheduleResponse>, t: Throwable) {
                Log.d( "Failure", t.message.toString())
            }
        })
    }

}