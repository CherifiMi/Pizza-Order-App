package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.core.graphics.scaleMatrix
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ui.theme.Blue1
import com.example.pizzaorderapp.ui.theme.MyWhite
import com.example.pizzaorderapp.ui.theme.Yellow
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
            Image(
                modifier = Modifier
                    .offset(0.dp, (-160).dp)
                    .scale(1.3f)
                    .fillMaxSize(),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.drawable.pizza),
                contentDescription ="ff" )
        }
        AnimatedVisibility(
            modifier = Modifier
                .weight(4f),
            visible = mainViewModel.firstmode.value,
            enter =  fadeIn(),
            exit =  fadeOut()
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .offset(0.dp, (-48).dp)
            ){
                for(i in 1..5){
                    Card(
                        backgroundColor = Yellow ,
                        shape = RoundedCornerShape(100),
                        modifier = Modifier
                            .width(24.dp)
                            .height(6.dp)
                            .padding(4.dp, 0.dp)
                            .alpha(
                                when (i) {
                                    mainViewModel.currentpizza.value -> 1f
                                    else -> 0.5f
                                }
                            )
                    ){}
                }
            }
        }
        AnimatedVisibility(
            modifier = Modifier
                .weight(44f),
            visible = mainViewModel.firstmode.value,
            // TODO: 4/4/2022 make it slid down
            enter =  slideIn(
                initialOffset = {fullSize->
                    IntOffset(0,-100)
                },
                animationSpec = tween(durationMillis = 1000)

            ),
            exit =  slideOut(
                targetOffset = {fullSize->
                    IntOffset(0,100)
                },
                animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                BottomInfoSheet(mainViewModel)
            }
        }
    }
}