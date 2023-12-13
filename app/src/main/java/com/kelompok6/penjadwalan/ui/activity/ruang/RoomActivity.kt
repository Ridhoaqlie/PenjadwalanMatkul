package com.kelompok6.penjadwalan.ui.activity.ruang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok6.penjadwalan.R
import com.kelompok6.penjadwalan.databinding.ActivityRoomBinding
import com.kelompok6.penjadwalan.model.DataClass
import com.kelompok6.penjadwalan.model.DataRoom
import com.kelompok6.penjadwalan.ui.activity.kelas.ClassAdapter

class RoomActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val roomList = listOf(
            DataRoom(1, "R1", "Ruang 1 Sistem Informasi"),
            DataRoom(2, "R2", "Ruang 2 Sistem Informasi"),
            DataRoom(20, "R3", "Ruang 3 Sistem Informasi"),
            DataRoom(21, "R4", "Ruang 4 Sistem Informasi"),
            DataRoom(22, "LAB1", "Laboratorium 1 Sistem Informasi")
        )

        binding.rvRoom.layoutManager = LinearLayoutManager(this)
        binding.rvRoom.setHasFixedSize(true)
        val adapter = RoomAdapter(this,roomList)
        binding.rvRoom.adapter = adapter
    }
}