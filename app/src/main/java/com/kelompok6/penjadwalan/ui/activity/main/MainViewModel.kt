package com.kelompok6.penjadwalan.ui.activity.main

import androidx.lifecycle.*
import com.kelompok6.penjadwalan.model.User
import com.kelompok6.penjadwalan.other.UserPreferences
import kotlinx.coroutines.launch


class MainViewModel (private val pref: UserPreferences) : ViewModel()  {


    fun getUser(): LiveData<User> {
        return pref.getUser().asLiveData()
    }

    fun logout() {
        viewModelScope.launch {
            pref.logout()
        }
    }
    fun saveUser(user: User) {
        viewModelScope.launch {
            pref.saveUser(user)
        }
    }
}