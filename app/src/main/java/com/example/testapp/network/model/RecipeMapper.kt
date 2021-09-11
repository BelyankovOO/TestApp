package com.example.testapp.network.model

import com.example.testapp.domain.Mapper
import com.example.testapp.domain.model.Recipe

class RecipeMapper: Mapper<RecipeResponse, Recipe> {

    override fun mapToMainModel(model: RecipeResponse): Recipe {
        return Recipe(
            id = model.pk,
            title = model.title,
            featuredImage = model.featuredImage,
            rating = model.rating,
            publisher = model.publisher,
            sourceUrl = model.sourceUrl,
            description = model.description,
            cookingInstructions = model.cookingInstructions,
            ingredients = model.ingredients.orEmpty(),
            dateAdded = model.dateAdded,
            dateUpdated = model.dateUpdated
        )
    }

    override fun mapFromMainModel(mainModel: Recipe): RecipeResponse {
        return RecipeResponse(
            pk = mainModel.id,
            title = mainModel.title,
            featuredImage = mainModel.featuredImage,
            rating = mainModel.rating,
            publisher = mainModel.publisher,
            sourceUrl = mainModel.sourceUrl,
            description = mainModel.description,
            cookingInstructions = mainModel.cookingInstructions,
            ingredients = mainModel.ingredients,
            dateAdded = mainModel.dateAdded,
            dateUpdated = mainModel.dateUpdated
        )
    }

    override fun toMainModelList(list: List<RecipeResponse>): List<Recipe> {
        return list.map {
            mapToMainModel(it)
        }
    }

    override fun fromMainModelList(list: List<Recipe>): List<RecipeResponse> {
        return list.map {
            mapFromMainModel(it)
        }
    }

}