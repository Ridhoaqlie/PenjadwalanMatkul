package com.kelompok6.penjadwalan.ui.activity.main

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.kelompok6.penjadwalan.databinding.ActivityMainBinding
import com.kelompok6.penjadwalan.other.UserPreferences
import com.kelompok6.penjadwalan.ui.activity.dosen.LecturerActivity
import com.kelompok6.penjadwalan.ui.activity.kelas.ClassActivity
import com.kelompok6.penjadwalan.ui.activity.pelajaran.CourseActivity
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.SchedulingActivity
import com.kelompok6.penjadwalan.ui.activity.ruang.RoomActivity
import com.kelompok6.penjadwalan.ui.activity.splashLoginRegister.LoginActivity
import com.kelompok6.penjadwalan.ui.viewmodel.ViewModelFactory

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        mainViewModel = ViewModelProvider(
                this,
                ViewModelFactory(UserPreferences.getInstance(dataStore))
        )[MainViewModel::class.java]

        mainViewModel.getUser().observe(this){
            if(!it.isLogin){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        val lecturerAnim = ObjectAnimator.ofFloat(binding.dataDosen, View.ALPHA, 1f).setDuration(550)
        val classAnim = ObjectAnimator.ofFloat(binding.dataKelas, View.ALPHA, 1f).setDuration(550)
        val roomAnim = ObjectAnimator.ofFloat(binding.dataRuang, View.ALPHA, 1f).setDuration(350)
        val courseAnim = ObjectAnimator.ofFloat(binding.mataPelajaran, View.ALPHA, 1f).setDuration(350)
        val schedulingAnim = ObjectAnimator.ofFloat(binding.penjadwalan, View.ALPHA, 1f).setDuration(350)

        val one = AnimatorSet().apply {
            playTogether(lecturerAnim,classAnim)
        }
        val two = AnimatorSet().apply {
            playTogether(roomAnim, courseAnim)
        }
        AnimatorSet().apply {
            playSequentially(one, two,schedulingAnim)
            start()
        }

        binding.apply {
            dataDosen.setOnClickListener {
                startActivity(Intent(this@MainActivity, LecturerActivity::class.java))
            }
            dataKelas.setOnClickListener {
                startActivity(Intent(this@MainActivity, ClassActivity::class.java))
            }
            dataRuang.setOnClickListener {
                startActivity(Intent(this@MainActivity, RoomActivity::class.java))
            }
            mataPelajaran.setOnClickListener {
                startActivity(Intent(this@MainActivity, CourseActivity::class.java))
            }
            penjadwalan.setOnClickListener {
                startActivity(Intent(this@MainActivity, SchedulingActivity::class.java))
            }
            btnLogout.setOnClickListener{
                mainViewModel.logout()
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
                finish()
            }
        }



    }
}