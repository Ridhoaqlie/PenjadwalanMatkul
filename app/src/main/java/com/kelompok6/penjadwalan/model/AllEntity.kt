package com.kelompok6.penjadwalan.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataLecturer(
    val id_dosen: Int,
    val nama_dosen: String,
    val jenis_kelamin: String,
    val pendidikan: String,
    val alamat: String,
    val nip: String,
    val no_ponsel: String
):Parcelable

@Parcelize
data class User(
    val email: String,
    val password: String,
    val isLogin: Boolean
):Parcelable

@Parcelize
data class DataClass(
    val id_kelas: Int,
    val nama_kelas: String,
    val kode_kelas: String
):Parcelable

@Parcelize
data class DataCourse(
    val id_mapel: Int,
    val nama_pelajaran: String,
    val kode_pelajaran: String,
    val tahun_ajar: String
):Parcelable

@Parcelize
data class DataRoom(
    val id_ruang: Int,
    val kode_ruang: String,
    val nama_ruang: String
):Parcelable