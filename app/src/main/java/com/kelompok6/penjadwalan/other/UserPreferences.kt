package com.kelompok6.penjadwalan.other

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.kelompok6.penjadwalan.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreferences private constructor(private val dataStore: DataStore<Preferences>) {

    fun getUser(): Flow<User> {
        return dataStore.data.map {
            User(
                it[EMAIL] ?: "",
                it[PASSWORD] ?: "",
                it[ISLOGIN] ?: false
            )
        }
    }

    suspend fun saveUser(user: User) {
        dataStore.edit {
            it[EMAIL] = user.email
            it[PASSWORD] = user.password
            it[ISLOGIN] = user.isLogin
        }
    }

    suspend fun logout() {
        dataStore.edit {
            it[ISLOGIN] = false
            it[EMAIL] = ""
            it[PASSWORD] = ""
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: UserPreferences? = null
        private val EMAIL = stringPreferencesKey("email")
        private val PASSWORD = stringPreferencesKey("password")
        private val ISLOGIN = booleanPreferencesKey("isLogin")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = UserPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }
}