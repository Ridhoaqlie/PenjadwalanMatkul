package com.kelompok6.penjadwalan.ui.activity.penjadwalan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kelompok6.penjadwalan.databinding.ActivityAddScheduleBinding


class AddScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddScheduleBinding
    private lateinit var addViewModel: AddViewModel

    companion object{
        const val CHECK_COME = ""
        const val A = "A"
        const val B = "B"
        const val C = "C"
        const val D = "D"
        const val F = "F"
        const val G = "G"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        addViewModel = AddViewModel()

        val checkCome = intent.getStringExtra(CHECK_COME).toString()
        val dJadwal = intent.getStringExtra(G).toString()

        binding.apply {
            if(checkCome == "1"){
                textViewa.visibility = View.VISIBLE
                idJadwalView.visibility = View.VISIBLE
                idJadwalView.text = dJadwal
                addCourse.setText(intent.getStringExtra(A).toString())
                addClass.setText(intent.getStringExtra(B).toString())
                addRoom.setText(intent.getStringExtra(C).toString())
                addDay.setText(intent.getStringExtra(D).toString())
                addNip.setText(intent.getStringExtra(F).toString())
            }
            button.setOnClickListener {
                val ddCourse = addCourse.text.toString()
                val ddClass = addClass.text.toString()
                val ddRoom = addRoom.text.toString()
                val ddDay = addDay.text.toString()
                val ddStart = addStart.text.toString()
                val ddEnd = addEnd.text.toString()
                val ddNip = addNip.text.toString()
                progressBar.visibility = View.VISIBLE
                    if(ddClass.isNotEmpty() && ddCourse.isNotEmpty() && ddRoom.isNotEmpty() &&
                        ddEnd.isNotEmpty() && ddNip.isNotEmpty()&& ddRoom.isNotEmpty() && ddStart.isNotEmpty()){
                        if(checkCome == "1"){
                            addViewModel.editSchedule(ddNip,ddClass,
                                ddCourse,ddRoom,ddDay,
                                ddStart,ddEnd,dJadwal){
                                intentMain(checkCome)
                            }
                        }else{
                            addViewModel.addSchedule(ddNip,ddClass,
                                ddCourse,ddRoom,ddDay,
                                ddStart,ddEnd){
                                intentMain(checkCome)
                            }
                        }
                    }
                    else Toast.makeText(applicationContext, "masukkan semua data", Toast.LENGTH_SHORT).show()

            }
        }

    }

    private fun intentMain(checkCome: String){
        binding.progressBar.visibility = View.GONE
        if(checkCome == "1"){
        Toast.makeText(this, "Berhasil mengedit data", Toast.LENGTH_SHORT).show()
        } else Toast.makeText(this, "Berhasil menambah data", Toast.LENGTH_SHORT).show()
        finish()
    }
}