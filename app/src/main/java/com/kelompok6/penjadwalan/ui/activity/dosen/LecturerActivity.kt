package com.kelompok6.penjadwalan.ui.activity.dosen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok6.penjadwalan.databinding.ActivityLecturerBinding
import com.kelompok6.penjadwalan.model.DataLecturer

class LecturerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLecturerBinding

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLecturerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val lectureList = listOf(
            DataLecturer(3, "Ananda faridhatul Ulva, S.Kom, M.Kom", "Perempuan", "S2", "lhokseumawe", "198806192019032020", "**********"),
            DataLecturer(4, "FAKHRUDDIN AHMAD NASUTION, S.T., M.T", "Laki-Laki", "S2", "lhokseumawe", "567569", "**********"),
            DataLecturer(6, "TAUFIQ, S.T., M.T", "Laki-Laki", "S2", "lhokseumawe", "567571", "**********"),
            DataLecturer(13, "MUKHLIS ABD MUTHALIB, ST., M.Eng., Ph.D	", "Laki-Laki", "S2", "lhokseumawe", "567578", "**********"),
            DataLecturer(46, "Zalfie Ardian, S. Kom., M. Eng", "laki-laki", "S2", "lhok", "5465465", "*****"),
            DataLecturer (48, "S.TTEUKU MULTAZAM, M.T", "laki-laki", "S2", "lhok", "4143242", "*******"),
            DataLecturer (50, "Himmatur Rijal, ST., M. Sc", "perempuan", "S2", "lhok", "7474754", "*******"),
            DataLecturer(51, "MUHAMMAD DANIL, S. Kom., M. Kom", "laki-laki", "S2", "lhok", "8768787",""),
            DataLecturer (52, "ILHAM SAHPUTRA, ST., M.Cs", "laki-laki", "S2", "lhok", "6757558765",""),
            DataLecturer (53, "Teuku Afriliansyah, S. Kom., M. Kom", "laki-laki", "S2", "lhok", "87687686",""),
            DataLecturer (54, "RAHMA FITRIA, B.TECH(HONS).,M.Sc", "perempuan", "S2", "lhok", "8585855",""),
            DataLecturer(55, "Muhammad Ikhwani, M.Sc", "laki-laki", "S2", "lhok", "69696969",""),
            DataLecturer (56, "DESVINA YULISDA, S.ST., M.S", "perempuan", "S2", "lhok", "78586865",""),
            DataLecturer(57, "S.TNANDA SITTI NURFEBRUARY, M.T", "laki-laki", "S2", "lhok", "97968758",""),
            DataLecturer (58, "MUTAMMIMUL ULA, S. Kom., M. Cs", "laki-laki", "S2", "lhok", "654765", "******"),
            DataLecturer(59, "ILHAM SAHPUTRA, ST., M.Cs", "laki-laki", "S2", "lhok", "6775","")
        )

        binding.rvLecturer.layoutManager = LinearLayoutManager(this)
        binding.rvLecturer.setHasFixedSize(true)
        val adapter = LecturerAdapter(this,lectureList){
            val intent = Intent(this, DetailDosenActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
        binding.rvLecturer.adapter = adapter

    }

}