package com.example.pizzaovenapp.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaovenapp.R

@Composable
fun PizzaSection() {
    val pagerState = rememberPagerState(pageCount = { 4 })
    Box{
        Image(
            painter = painterResource(R.drawable.plate),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        PizzaPager(state = pagerState)
    }
}

@Composable
fun PizzaPager(state: PagerState) {
    HorizontalPager(state = state) {

    }
}