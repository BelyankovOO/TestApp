package com.example.testapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.testapp.database.AppDatabase
import com.example.testapp.database.dao.RecipeDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    fun provideRecipeDao(appDatabase: AppDatabase) : RecipeDao {
        return appDatabase.recipeDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
        "Recipe"
        ).build()
    }
}