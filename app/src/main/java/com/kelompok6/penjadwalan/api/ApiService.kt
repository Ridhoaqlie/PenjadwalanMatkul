package com.kelompok6.penjadwalan.api

import com.kelompok6.penjadwalan.model.*
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @FormUrlEncoded
    @POST("Jadwalsiswa")
    fun addSchedule(
        @Field("nip") nip: String,
        @Field("kode_kelas") kode_kelas: String,
        @Field("kode_mata_pelajaran") kode_mata_pelajaran: String,
        @Field("kode_ruang") kode_ruang: String,
        @Field("hari") hari: String,
        @Field("jam_awal") jam_awal: String,
        @Field("jam_selesai") jam_selesai: String
    ): Call <AddScheduleResponse>

    @GET("Jadwalsiswa")
    fun getSchedule(): Call <GetScheduleResponse>

    @FormUrlEncoded
    @PUT("Jadwalsiswa")
    fun editSchedule(
        @Field("nip") nip: String,
        @Field("kode_kelas") kode_kelas: String,
        @Field("kode_mata_pelajaran") kode_mata_pelajaran: String,
        @Field("kode_ruang") kode_ruang: String,
        @Field("hari") hari: String,
        @Field("jam_awal") jam_awal: String,
        @Field("jam_selesai") jam_selesai: String,
        @Field("id_jadwal") id_jadwal: String
    ): Call <EditScheduleResponse>


    @GET("Delete/{id_jadwal}")
    fun deleteSchedule(
        @Query("id_jadwal") id_jadwal: String
    ): Call<DeleteScheduleResponse>

}
