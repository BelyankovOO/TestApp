package com.example.testapp.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.domain.model.Recipe
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun RecipeView(
    recipe: Recipe,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        recipe.title?.let { title ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h3
                )
                val rank = recipe.rating.toString()
                Text(
                    text = rank,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h5
                )
            }
        }
        recipe.publisher?.let { publisher ->
            val updated = recipe.dateUpdated
            Text(
                text = if (updated != null) {
                    "Updated ${updated} by ${publisher}"
                } else {
                    "By ${publisher}"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.caption
            )
        }
        recipe.description?.let { description ->
            if (description != "N/A") {
                Text(
                    text = description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    style = MaterialTheme.typography.body1
                )
            }
        }
        for (ingredient in recipe.ingredients) {
            Text(
                text = ingredient,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                style = MaterialTheme.typography.body1
            )
        }
        recipe.cookingInstructions?.let { instructions ->
            Text(
                text = instructions,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@ExperimentalCoroutinesApi
@Preview
@Composable
fun PreviewRecipeView() {
    RecipeView(recipe =
        Recipe(
          31,
            "Fancy Macaroni",
            "jessica",
            "https://nyc3.digitaloceanspaces.com/food2fork/food2fork-static/featured_images/31/featured_image.png",
            41,
            "http://thepioneerwoman.com/cooking/2009/12/fancy-macaroni/",
            "N/A",
            null,
            listOf(
                "4 cups Macaroni",
                "1/2 cup Half-and-half",
                "10 slices Regular Bacon",
                "2 cups Whole Or 2% Milk",
                "1/4 cup All-purpose Flour",
                "2 whole Egg Yolks, Beaten",
                "Salt And Pepper, to taste",
                "1/2 cup Grated Fontina Cheese",
                "1/2 cup Grated Gruyere Cheese",
                "8 Tablespoons Butter (Salted Butter)",
                "1/2 cup Grated Parmigiano Reggiano Cheese",
                "4 ounces, weight Chevre (soft Goat Cheese)",
                "2 whole Medium Onions, Cut In Half And Sliced Thin",
                "1 Tablespoon Bacon Grease (reserved From Bacon Sli"
            ),
            "November 11 2020",
            "November 11 2020",
        )
    )
}
