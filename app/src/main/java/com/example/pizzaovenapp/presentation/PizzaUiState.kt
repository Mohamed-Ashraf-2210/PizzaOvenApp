package com.example.pizzaovenapp.presentation

import com.example.pizzaovenapp.data.PizzaIngredients
import com.example.pizzaovenapp.data.PizzaSize

data class PizzaUiState(
    val pizzaItems: List<Pizza> = emptyList(),
    val pizzaSize: PizzaSize = PizzaSize.MEDIUM,
    val pizzaSelectedId: Int = 0
)

data class Pizza(
    val id: Int,
    val breadImage: Int,
    val ingredientsSelectedId: Int = -1,
    val ingredients: List<Ingredient> = emptyList()
)

data class Ingredient(
    val id: Int,
    val name: PizzaIngredients,
    val ingredientImageCustomize: Int,
    val ingredientGroup: Int,
    val isSelected: Boolean = false
)