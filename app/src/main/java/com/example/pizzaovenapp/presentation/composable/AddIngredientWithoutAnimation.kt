package com.example.pizzaovenapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun AddIngredientWithoutAnimation(ingredientGroup: Painter) {
    Image(
        painter = ingredientGroup,
        contentDescription = null,
        modifier = Modifier
            .padding(36.dp)
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
}