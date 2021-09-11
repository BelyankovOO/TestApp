package com.example.testapp.network

import com.example.testapp.network.model.RecipeResponse

data class RecipeSearchResponse(

    var count: Int,
    var results: List<RecipeResponse>

)