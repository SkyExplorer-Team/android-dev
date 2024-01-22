package com.capstone.skyexplorer.pref

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ApplicationPreferences @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

    private val showOnboarding = booleanPreferencesKey("showOnboarding")

    fun getShowOnBoarding(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[showOnboarding] ?: true
        }
    }

    suspend fun setShowOnboarding(data : Boolean) {
        dataStore.edit { preferences ->
            preferences[showOnboarding] = data
        }
    }

}