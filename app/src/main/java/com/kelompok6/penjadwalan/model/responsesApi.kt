package com.kelompok6.penjadwalan.model

import com.google.gson.annotations.SerializedName

data class AddScheduleResponse(
    @field:SerializedName("nip")
    val nip: String,
    @field:SerializedName("kode_kelas")
    val kode_kelas: String,
    @field:SerializedName("kode_mata_pelajaran")
    val kode_mata_pelajaran: String,
    @field:SerializedName("kode_ruang")
    val kode_ruang: String,
    @field:SerializedName("hari")
    val hari: String,
    @field:SerializedName("jam_awal")
    val jam_awal: String,
    @field:SerializedName("jam_selesai")
    val jam_selesai: String,
)

data class EditScheduleResponse(
    @field:SerializedName("nip")
    val nip: String,
    @field:SerializedName("kode_kelas")
    val kode_kelas: String,
    @field:SerializedName("kode_mata_pelajaran")
    val kode_mata_pelajaran: String,
    @field:SerializedName("kode_ruang")
    val kode_ruang: String,
    @field:SerializedName("hari")
    val hari: String,
    @field:SerializedName("jam_awal")
    val jam_awal: String,
    @field:SerializedName("jam_selesai")
    val jam_selesai: String,
    @field:SerializedName("id_jadwal")
    val id_jadwal: String,
)

data class DeleteScheduleResponse(
    @field:SerializedName("status")
    val status: Boolean,
    @field:SerializedName("message")
    val message: String
)

data class GetScheduleResponse(
    @field:SerializedName("status")
    val status: Boolean,
    @field:SerializedName("data")
    val data: ArrayList<GetScheduleResponseItem>,
)

data class GetScheduleResponseItem(
    @field:SerializedName("id_jadwal")
    val id_jadwal: String,
    @field:SerializedName("nip")
    val nip: String,
    @field:SerializedName("kode_kelas")
    val kode_kelas: String,
    @field:SerializedName("kode_mata_pelajaran")
    val kode_mata_pelajaran: String,
    @field:SerializedName("kode_ruang")
    val kode_ruang: String,
    @field:SerializedName("hari")
    val hari: String,
    @field:SerializedName("jam_awal")
    val jam_awal: String,
    @field:SerializedName("jam_selesai")
    val jam_selesai: String,
)