package com.kelompok6.penjadwalan.ui.activity.penjadwalan

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import com.kelompok6.penjadwalan.api.ApiConfig
import com.kelompok6.penjadwalan.model.AddScheduleResponse
import com.kelompok6.penjadwalan.model.EditScheduleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddViewModel: ViewModel() {

    fun addSchedule(nip: String, kelas: String, course: String, room: String
    , day: String, start: String, end: String, callback: () -> Unit){
        ApiConfig.getApiService().addSchedule(nip, kelas,
        course, room, day, start, end)
            .enqueue(object : Callback<AddScheduleResponse> {
                override fun onResponse(
                    call: Call<AddScheduleResponse>,
                    response: Response<AddScheduleResponse>
                ) {
                    if (response.isSuccessful) {
                        val schedule = response.body()
                        if(schedule!=null){
                            callback.invoke()
                        }
                    }
                }

                override fun onFailure(call: Call<AddScheduleResponse>, t: Throwable) {
                    Log.d(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                }

            })
    }

    fun editSchedule(nip: String, kelas: String, course: String, room: String
                  , day: String, start: String, end: String, idjadwal: String, callback: () -> Unit){
        ApiConfig.getApiService().editSchedule(nip, kelas,
            course, room, day, start, end, idjadwal)
            .enqueue(object : Callback<EditScheduleResponse> {
                override fun onResponse(
                    call: Call<EditScheduleResponse>,
                    response: Response<EditScheduleResponse>
                ) {
                    if (response.isSuccessful) {
                        val schedule = response.body()
                        if(schedule!=null){
                            Log.d(ContentValues.TAG, "onSuccess: ${response.message()}")
                            callback.invoke()
                        }
                    }
                }

                override fun onFailure(call: Call<EditScheduleResponse>, t: Throwable) {
                    Log.d(ContentValues.TAG, "onFailure: ${t.message.toString()}")
                }

            })
    }


}