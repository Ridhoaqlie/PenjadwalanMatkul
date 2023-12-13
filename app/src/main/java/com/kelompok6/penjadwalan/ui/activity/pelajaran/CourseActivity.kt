package com.kelompok6.penjadwalan.ui.activity.pelajaran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kelompok6.penjadwalan.databinding.ActivityCourseBinding
import com.kelompok6.penjadwalan.model.DataCourse

class CourseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val courseList = listOf(
            DataCourse(5, "INTERNET UNTUK SEGALA", "TSI2643", "2020/2021"),
            DataCourse(30, "MANAJEMEN DAN ADMINISTRASI BASIS DATA", "TSI2343", "2020/2021"),
            DataCourse(46, "PEMOGRAMAN WEB 2", "TSI2243", "2020/2021"),
            DataCourse(47, "PEMOGRAMAN MOBILE 2", "TSI1943", "2020/2021"),
            DataCourse(48, "PENAMBANGAN DATA", "TSI2443", "2020/2021"),
            DataCourse(49, "REKAYASA PERANGKAT LUNAK", "TSI2043", "2020/2021"),
            DataCourse(50, "SISTEM INTERPRISE", "TSI2543", "2020/2021"),
            DataCourse(51, "SISTEM PENDUKUNG KEPUTUSAN", "TSI2143", "2020/2021")
        )

        binding.rvCourse.layoutManager = LinearLayoutManager(this)
        binding.rvCourse.setHasFixedSize(true)
        val adapter = CourseAdapter(this,courseList)
        binding.rvCourse.adapter = adapter
    }
}