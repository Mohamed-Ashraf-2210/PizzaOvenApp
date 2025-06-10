package com.example.pizzaovenapp.presentation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaovenapp.R
import com.example.pizzaovenapp.data.PizzaSize
import com.example.pizzaovenapp.presentation.composable.AddCart
import com.example.pizzaovenapp.presentation.composable.AddIngredientWhitAnimation
import com.example.pizzaovenapp.presentation.composable.AddIngredientWithoutAnimation
import com.example.pizzaovenapp.presentation.composable.PizzaScreenTopBar
import com.example.pizzaovenapp.ui.theme.Gray
import com.example.pizzaovenapp.ui.theme.LightGreen
import com.example.pizzaovenapp.ui.theme.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun PizzaScreen(viewModel: PizzaViewModel = koinViewModel()) {
    val state = viewModel.uiState.collectAsState().value

    PizzaContent(
        state = state,
        updatePizzaSelection = viewModel::updatePizzaSelection,
        onChangePizzaSize = viewModel::onChangePizzaSize,
        onIngredientClick = viewModel::onIngredientClick,
        removeIngredientsSelectedId = viewModel::removeIngredientsSelectedId
    )
}

@Composable
fun PizzaContent(
    state: PizzaUiState,
    updatePizzaSelection: (Int) -> Unit,
    onChangePizzaSize: (PizzaSize) -> Unit,
    onIngredientClick: (Ingredient) -> Unit,
    removeIngredientsSelectedId: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val pager = rememberPagerState(pageCount = { state.pizzaItems.size })

    val animationPizzaSize by animateFloatAsState(
        targetValue = when (state.pizzaSize) {
            PizzaSize.SMALL -> 0.7f
            PizzaSize.MEDIUM -> 0.8f
            PizzaSize.LARGE -> 0.9f
        },
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessHigh
        )
    )


    val sizeSelectedBias by animateFloatAsState(
        targetValue = when (state.pizzaSize) {
            PizzaSize.SMALL -> -1.3f
            PizzaSize.MEDIUM -> 0f
            PizzaSize.LARGE -> 1.3f
        }
    )
    val animationSizeSelected by remember {
        derivedStateOf {
            BiasAlignment(
                horizontalBias = sizeSelectedBias,
                verticalBias = 0f
            )
        }
    }


    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PizzaScreenTopBar()

        Box(Modifier.height(320.dp)) {
            Image(
                painter = painterResource(R.drawable.plate),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(230.dp)
            )


            HorizontalPager(
                modifier = Modifier.align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically,
                state = pager,
            ) {
                updatePizzaSelection(pager.currentPage)
                removeIngredientsSelectedId()
                Box(
                    Modifier
                        .fillMaxWidth()
                        .size(230.dp)
                        .scale(animationPizzaSize)
                ) {
                    val pizzaSelected = state.pizzaItems[pager.currentPage]
                    Image(
                        painter = painterResource(pizzaSelected.breadImage),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center),
                    )
                    pizzaSelected.ingredients.filter { it.isSelected }.forEach {
                        if (it.id == pizzaSelected.ingredientsSelectedId) {
                            AddIngredientWhitAnimation(painterResource(it.ingredientGroup))

                        } else
                            AddIngredientWithoutAnimation(painterResource(it.ingredientGroup))
                    }
                }
            }
        }



        Text(
            text = "$17",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Box(Modifier.padding(top = 16.dp)) {
            Box(
                Modifier
                    .size(40.dp)
                    .shadow(8.dp, shape = CircleShape)
                    .clip(CircleShape)
                    .background(White)
                    .align(animationSizeSelected)
            )
            Row(
                modifier = Modifier.align(Alignment.Center),
                horizontalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Text(
                    text = "S",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = interactionSource,
                    ) {
                        onChangePizzaSize(PizzaSize.SMALL)
                    }
                )
                Text(
                    text = "M",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = interactionSource,
                    ) {
                        onChangePizzaSize(PizzaSize.MEDIUM)
                    }
                )
                Text(
                    text = "L",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable(
                        indication = null,
                        interactionSource = interactionSource,
                    ) {
                        onChangePizzaSize(PizzaSize.LARGE)
                    }
                )
            }
        }


        Text(
            text = "CUSTOMIZE YOUR PIZZA",
            color = Gray,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(top = 24.dp, start = 8.dp, end = 8.dp)
                .align(Alignment.Start)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state.pizzaItems[state.pizzaSelectedId].ingredients) {
                Image(
                    painter = painterResource(it.ingredientImageCustomize),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(54.dp)
                        .background(color = if (it.isSelected) LightGreen else Color.Transparent)
                        .graphicsLayer(scaleX = 0.7f, scaleY = 0.7f)
                        .clickable(
                            indication = null,
                            interactionSource = interactionSource,
                        ) {
                            onIngredientClick(it)
                        }
                )
            }
        }


        Spacer(Modifier.weight(1f))
        AddCart()
    }
}