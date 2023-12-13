package com.kelompok6.penjadwalan.ui.activity.penjadwalan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.kelompok6.penjadwalan.databinding.ActivityScheduleDetailBinding
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.A
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.B
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.C
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.CHECK_COME
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.D
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.F
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.AddScheduleActivity.Companion.G

class ScheduleDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScheduleDetailBinding
    private lateinit var viewModel: SchedulingDetailViewModel

    companion object{
        val EXTRA_ID_JADWAL = "EXTRA_ID_JADWAL"
        val EXTRA_NIP = "EXTRA_NIP"
        val EXTRA_CLASS_CODE = "EXTRA_CLASS_KODE"
        val EXTRA_ROOM_CODE = "EXTRA_ROOM_CODE"
        val EXTRA_COURSE_CODE = "EXTRA_COURSE_CODE"
        val EXTRA_DAY = "EXTRA_DAY"
        val EXTRA_TIME = "EXTRA_TIME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = SchedulingDetailViewModel()

        val course = intent.getStringExtra(EXTRA_COURSE_CODE).toString()
        val aClass = intent.getStringExtra(EXTRA_CLASS_CODE).toString()
        val room = intent.getStringExtra(EXTRA_ROOM_CODE).toString()
        val day = intent.getStringExtra(EXTRA_DAY).toString()
        val time = intent.getStringExtra(EXTRA_TIME).toString()
        val lecturer = intent.getStringExtra(EXTRA_NIP).toString()
        val idSchedule = intent.getStringExtra(EXTRA_ID_JADWAL).toString()

        binding.apply {
            detailPelajaran.text = course
            detailJam.text = day +", "+ time
            detailDosen.text = "With ${lecturer}"
            detailKelas.text = aClass
            detailRuang.text = room
            idJadwalDetail.text = "Id jadwal: $idSchedule"

            detailEdit.setOnClickListener{
                val intent = Intent(this@ScheduleDetailActivity, AddScheduleActivity::class.java).also {
                    it.putExtra(CHECK_COME, "1")
                    it.putExtra(A,course)
                    it.putExtra(B,aClass)
                    it.putExtra(C,room)
                    it.putExtra(D,day)
                    it.putExtra(F,lecturer)
                    it.putExtra(G,idSchedule)
                }
                startActivity(intent)
                finish()
            }
            detailDelete.setOnClickListener {
                    Log.e("ABCD",idSchedule)
                binding.progressBar3.visibility = View.VISIBLE
                viewModel.deleteCourse(idSchedule){
                    finishActivity()
                }
            }
        }

    }

    private fun finishActivity(){
        binding.progressBar3.visibility = View.GONE
        finish()
    }
}