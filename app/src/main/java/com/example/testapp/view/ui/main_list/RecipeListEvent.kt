package com.example.testapp.view.ui.main_list

sealed class RecipeListEvent {

    object NewSearchEvent : RecipeListEvent()

    object NextPageEvent : RecipeListEvent()

    object RestoreStateEvent: RecipeListEvent()
}