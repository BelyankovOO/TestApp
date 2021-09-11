package com.example.testapp.repository

import com.example.testapp.database.dao.RecipeDao
import com.example.testapp.domain.model.Recipe
import com.example.testapp.network.RetrofitService
import com.example.testapp.network.model.RecipeMapper

class RecipeRepositoryImpl(
    private val recipeService: RetrofitService,
    private val mapper: RecipeMapper,
    private val recipeDao: RecipeDao
) : RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toMainModelList(recipeService.search(token = token, page = page, query = query).results)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToMainModel(recipeService.get(token = token, id))
    }

    override suspend fun insert(list: List<Recipe>) {
        recipeDao.insertAll(list)
    }

    override suspend fun getFromDb(): List<Recipe> {
        return recipeDao.getAllRecipe()
    }

}