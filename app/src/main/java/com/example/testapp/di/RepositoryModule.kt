package com.example.testapp.di

import com.example.testapp.database.dao.RecipeDao
import com.example.testapp.network.RetrofitService
import com.example.testapp.network.model.RecipeMapper
import com.example.testapp.repository.RecipeRepository
import com.example.testapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RetrofitService,
        recipeMapper: RecipeMapper,
        recipeDao: RecipeDao
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeMapper,
            recipeDao = recipeDao
        )
    }

}