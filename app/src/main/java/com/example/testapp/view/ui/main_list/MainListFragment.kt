package com.example.testapp.view.ui.main_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.testapp.App
import com.example.testapp.view.components.RecipeList
import com.example.testapp.view.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
class MainListFragment: Fragment() {
    @Inject
    lateinit var application: App

    private val viewModel: MainListViewModel by viewModels()

    @ExperimentalCoroutinesApi
    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value

                val loading = viewModel.loading.value

                val page = viewModel.page.value

                AppTheme(
                    displayProgressBar = loading,
                    darkTheme = application.isDark.value,
                ) {
                    RecipeList(
                        loading = loading,
                        recipes = recipes,
                        onChangeScrollPosition = viewModel::onChangeRecipeScrollPosition,
                        page = page,
                        onTriggerNextPage = { viewModel.onTriggerEvent(RecipeListEvent.NextPageEvent) },
                        navController = findNavController()
                    )
                }
            }

        }
    }
}
