package com.example.pizzaovenapp.presentation.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaovenapp.R

@Composable
fun PizzaScreenTopBar() {
    Row(Modifier
        .fillMaxWidth()
        .padding(top = 50.dp, start = 16.dp, end = 16.dp)) {
        Icon(
            painter = painterResource(R.drawable.outline_arrow_back_24),
            contentDescription = null,
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "Pizza",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.weight(1f))
        Icon(
            painter = painterResource(R.drawable.baseline_favorite_24),
            contentDescription = null,
        )
    }
}