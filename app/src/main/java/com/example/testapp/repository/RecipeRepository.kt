package com.example.testapp.repository

import androidx.lifecycle.LiveData
import com.example.testapp.domain.model.Recipe

interface RecipeRepository {

    suspend fun search(token: String, page: Int, query: String): List<Recipe>

    suspend fun get(token: String, id: Int): Recipe

    suspend fun insert(list: List<Recipe>)

    suspend fun getFromDb(): List<Recipe>
}