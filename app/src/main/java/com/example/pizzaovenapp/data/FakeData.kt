package com.example.pizzaovenapp.data

import com.example.pizzaovenapp.R
import com.example.pizzaovenapp.presentation.Ingredient
import com.example.pizzaovenapp.presentation.Pizza

object FakeData {

    fun pizzaData(): List<Pizza> {
        return listOf(
            Pizza(
                id = 0,
                breadImage = R.drawable.bread_1,
                ingredients = ingredientsData()
            ),
            Pizza(
                id = 1,
                breadImage = R.drawable.bread_2,
                ingredients = ingredientsData()
            ),
            Pizza(
                id = 2,
                breadImage = R.drawable.bread_3,
                ingredients = ingredientsData()
            ),
            Pizza(
                id = 3,
                breadImage = R.drawable.bread_4,
                ingredients = ingredientsData()
            ),
            Pizza(
                id = 4,
                breadImage = R.drawable.bread_5,
                ingredients = ingredientsData()
            ),
        )
    }

    private fun ingredientsData(): List<Ingredient> {
        return listOf(
            Ingredient(
                id = 1,
                name = PizzaIngredients.BASIL,
                ingredientImageCustomize = R.drawable.basil,
                ingredientGroup = R.drawable.basil_group,
            ),
            Ingredient(
                id = 2,
                name = PizzaIngredients.ONION,
                ingredientImageCustomize = R.drawable.onion,
                ingredientGroup = R.drawable.onion_group,
            ),
            Ingredient(
                id = 3,
                name = PizzaIngredients.BROCCOLI,
                ingredientImageCustomize = R.drawable.broccoli,
                ingredientGroup = R.drawable.broccoli_group,
            ),
            Ingredient(
                id = 4,
                name = PizzaIngredients.MUSHROOM,
                ingredientImageCustomize = R.drawable.mushroom,
                ingredientGroup = R.drawable.mushroom_group,
            ),
            Ingredient(
                id = 5,
                name = PizzaIngredients.SAUSAGE,
                ingredientImageCustomize = R.drawable.sausage,
                ingredientGroup = R.drawable.sausage_group,
            ),
        )
    }
}