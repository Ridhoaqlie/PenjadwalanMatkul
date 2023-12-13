package com.kelompok6.penjadwalan.ui.activity.splashLoginRegister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.kelompok6.penjadwalan.R
import com.kelompok6.penjadwalan.ui.activity.main.MainActivity

class SplashActivity : AppCompatActivity() {

     private var splashTimeOut: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        Handler().postDelayed({
            Handler(Looper.getMainLooper())
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashTimeOut)
    }
}