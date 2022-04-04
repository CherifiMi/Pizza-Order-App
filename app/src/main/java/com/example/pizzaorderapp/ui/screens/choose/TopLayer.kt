package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.example.pizzaorderapp.viewModel.MainViewModel

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun TopLayer(mainViewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
    ){

        AnimatedVisibility(
            modifier = Modifier
                .weight(52f),
            visible = mainViewModel.firstmode.value,
            enter =  slideInVertically(),
            exit =  slideOutVertically()+ shrinkOut()
        ){
            BigPizzaImg()
        }

        AnimatedVisibility(
            modifier = Modifier
                .weight(4f),
            visible = mainViewModel.firstmode.value,
            enter =  fadeIn(),
            exit =  fadeOut()
        ) {
            SmallCards(mainViewModel)
        }

        AnimatedVisibility(
            modifier = Modifier
                .weight(44f),
            visible = mainViewModel.firstmode.value,
            // TODO: 4/4/2022 make it slid down
            enter =  slideIn(
                initialOffset = {fullSize->
                    IntOffset(0,fullSize.width/2)
                },
                animationSpec = tween(durationMillis = 300, easing = LinearOutSlowInEasing )

            ),
            exit =  slideOut(
                targetOffset = {fullSize->
                    IntOffset(0,fullSize.width/2)
                },
                animationSpec = tween(durationMillis = 300)
            )+ fadeOut()
        ) {
            BottomInfoSheet(mainViewModel)
        }
    }
}