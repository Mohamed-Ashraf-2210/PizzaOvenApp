package com.example.pizzaovenapp.presentation.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun AddIngredientWhitAnimation(ingredientGroup: Painter) {
    val scale = remember { Animatable(3f) }

    Image(
        painter = ingredientGroup,
        contentDescription = null,
        modifier = Modifier
            .padding(36.dp)
            .scale(scale.value)
            .fillMaxWidth(),
        alignment = Alignment.Center
    )
    LaunchedEffect(key1 = Unit) {
        scale.animateTo(targetValue = 1f)
    }
}