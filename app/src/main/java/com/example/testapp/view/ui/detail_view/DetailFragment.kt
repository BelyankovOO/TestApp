package com.example.testapp.view.ui.detail_view

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testapp.App
import com.example.testapp.TAG
import com.example.testapp.view.components.CircularProgressBar
import com.example.testapp.view.components.RecipeView
import com.example.testapp.view.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment: Fragment() {
    @Inject
    lateinit var application: App

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("recipeId")?.let { recipeId ->
            viewModel.onTriggerEvent(RecipeEvent.GetRecipeEvent(recipeId))
        }
    }

    @ExperimentalCoroutinesApi
    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val loading = viewModel.loading.value

                val recipe = viewModel.recipe.value

                AppTheme(
                    displayProgressBar = loading,
                    darkTheme = application.isDark.value,
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (loading && recipe == null) {
                            Log.d(TAG, "loading null")
                        } else recipe?.let {
                            RecipeView(
                                recipe = it,
                            )
                        }
                    }
                    CircularProgressBar(isDisplayed = loading)
                }
            }
        }
    }
}