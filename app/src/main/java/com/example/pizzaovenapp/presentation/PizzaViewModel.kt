package com.example.pizzaovenapp.presentation

import androidx.lifecycle.ViewModel
import com.example.pizzaovenapp.data.FakeData
import com.example.pizzaovenapp.data.PizzaSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PizzaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PizzaUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadPizzaData()
    }

    private fun loadPizzaData() {
        _uiState.update { it.copy(pizzaItems = FakeData.pizzaData()) }
    }

    fun updatePizzaSelection(id: Int) {
        _uiState.update { it.copy(pizzaSelectedId = id) }
    }
    fun removeIngredientsSelectedId() {
        _uiState.update { state ->
            val pizzaItemsUpdate = state.pizzaItems.map { pizza ->
                if (pizza.id == state.pizzaSelectedId) {
                    pizza.copy(ingredientsSelectedId = -1)
                } else pizza
            }
            state.copy(pizzaItems = pizzaItemsUpdate)
        }
    }

    fun onIngredientClick(ingredient: Ingredient) {
        _uiState.update { state ->
            val pizzaItemsUpdate = state.pizzaItems.map { pizza ->
                if (pizza.id == state.pizzaSelectedId) {
                    pizza.copy(
                        ingredients = pizza.ingredients.map { item ->
                            if (item.id == ingredient.id) {
                                item.copy(isSelected = !item.isSelected)
                            } else item
                        },
                        ingredientsSelectedId = ingredient.id
                    )

                } else pizza
            }
            state.copy(pizzaItems = pizzaItemsUpdate)

        }
    }

    fun onChangePizzaSize(pizzaSize: PizzaSize) {
        _uiState.update { it.copy(pizzaSize = pizzaSize) }
    }
}