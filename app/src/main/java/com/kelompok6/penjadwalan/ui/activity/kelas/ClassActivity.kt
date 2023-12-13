package com.kelompok6.penjadwalan.ui.activity.kelas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok6.penjadwalan.databinding.ActivityClassBinding
import com.kelompok6.penjadwalan.model.DataClass

class ClassActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val classList = listOf(
            DataClass(3, "A1 2020 Sistem Informasi", "A1"),
            DataClass(8, "A2 2020 Sistem Informasi", "A2"),
            DataClass(10, "A3 2020 Sistem Informasi", "A3"),
            DataClass(17, "A4 2020 Sistem Informasi", "A4"),
            DataClass(18, "A5 2020 Sistem Informasi", "A5")
            )
        binding.rvClass.layoutManager = LinearLayoutManager(this)
        binding.rvClass.setHasFixedSize(true)
        val adapter = ClassAdapter(this,classList)
        binding.rvClass.adapter = adapter
    }
}