package com.kelompok6.penjadwalan.ui.activity.dosen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kelompok6.penjadwalan.ui.activity.dosen.LecturerActivity.Companion.INTENT_PARCELABLE
import com.kelompok6.penjadwalan.databinding.ActivityDetailDosenBinding
import com.kelompok6.penjadwalan.model.DataLecturer

class DetailDosenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailDosenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDosenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataLecture = intent.getParcelableExtra<DataLecturer>(INTENT_PARCELABLE)

        binding.apply {
            dosenNama.text = "Nama : "+dataLecture?.nama_dosen.toString()
            dosenNip.text = "NIP : "+dataLecture?.nip.toString()
            dosenHp.text  = "No. HP : "+dataLecture?.no_ponsel.toString()
            dosenAlamat.text = "Alamat : "+dataLecture?.alamat.toString()
            dosenKelamin.text = "Jenis Kelamin : "+dataLecture?.jenis_kelamin.toString()
            dosenPendidikan.text = "Pendidikan : "+dataLecture?.pendidikan.toString()
        }



    }
}