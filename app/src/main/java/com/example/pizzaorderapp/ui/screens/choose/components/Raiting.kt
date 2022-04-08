package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ui.theme.Yellow

@Composable
fun Raiting(r: Float) {
    Box(
        Modifier
            .wrapContentHeight()
            .padding(32.dp, 0.dp)
    ){
        Box(modifier = Modifier
            .height(20.dp)
            .width((r * 96 / 100).dp)
            .background(Yellow))
        Image(painter = painterResource(id = R.drawable.starmask), contentDescription = "hi")
    }
}