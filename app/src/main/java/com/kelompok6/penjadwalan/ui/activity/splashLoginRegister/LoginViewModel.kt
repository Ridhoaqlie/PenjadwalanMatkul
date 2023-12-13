package com.kelompok6.penjadwalan.ui.activity.splashLoginRegister

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelompok6.penjadwalan.model.User
import com.kelompok6.penjadwalan.other.UserPreferences
import kotlinx.coroutines.launch

class LoginViewModel (private val pref: UserPreferences) : ViewModel()  {

    fun saveUser(user: User, Callback: ()-> Unit) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
        Callback.invoke()
    }
}