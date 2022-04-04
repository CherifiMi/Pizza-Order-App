package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.R

@Composable
fun BigPizzaImg() {
    Image(
        modifier = Modifier
            .offset(0.dp, (-160).dp)
            .scale(1.3f)
            .fillMaxSize(),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = R.drawable.pizza),
        contentDescription ="ff" )
}