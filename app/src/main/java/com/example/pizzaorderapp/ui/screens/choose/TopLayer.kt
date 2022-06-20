package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pizzaorderapp.ui.theme.Blue1
import com.example.pizzaorderapp.ui.theme.MyWhite
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
            exit =  slideOutVertically()+ fadeOut()
        ){
            Box() {

                //BigPizzaImg(mainViewModel)

                LazyRow(
                    Modifier
                        .offset(0.dp, (-160).dp)
                        .scale(1.3f)
                        .fillMaxSize().background(MyWhite)
                ){
                    items(items = mainViewModel.allPizza.toList()){
                        Text(text = it.name)
                        //Image(
                        //    painter = rememberAsyncImagePainter(it.pic_url),
                        //    contentDescription = "")
                    }
                }
            }

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