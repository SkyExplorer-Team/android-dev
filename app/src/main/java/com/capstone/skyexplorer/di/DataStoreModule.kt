package com.capstone.skyexplorer.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.capstone.skyexplorer.pref.ApplicationPreferences
import com.capstone.skyexplorer.pref.TokenPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "skyExplorer")
@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule{

    @Provides
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> = context.dataStore

    @Provides
    @Singleton
    fun provideTokenPreferences(
        dataStore: DataStore<Preferences>
    ): TokenPreferences = TokenPreferences(dataStore)

    @Provides
    @Singleton
    fun provideApplicationPreferences(
        dataStore: DataStore<Preferences>
    ): ApplicationPreferences = ApplicationPreferences(dataStore)
}