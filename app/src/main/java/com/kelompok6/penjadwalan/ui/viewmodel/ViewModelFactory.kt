package com.kelompok6.penjadwalan.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kelompok6.penjadwalan.other.UserPreferences
import com.kelompok6.penjadwalan.ui.activity.main.MainViewModel
import com.kelompok6.penjadwalan.ui.activity.penjadwalan.SchedulingViewModel
import com.kelompok6.penjadwalan.ui.activity.splashLoginRegister.LoginViewModel

class ViewModelFactory (private val pref: UserPreferences) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(pref) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(pref) as T
            }
            modelClass.isAssignableFrom(SchedulingViewModel::class.java) -> {
                SchedulingViewModel(pref) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}