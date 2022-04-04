package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pizzaorderapp.ui.theme.Blue1
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun BigPizzaImg(mainViewModel: MainViewModel) {
    Image(
        modifier = Modifier
            .offset(0.dp, (-160).dp)
            .scale(1.3f)
            .clip(CircleShape)
            .fillMaxSize(),
        contentScale = ContentScale.FillWidth,
        painter = rememberAsyncImagePainter(mainViewModel.pic_url.value),
        contentDescription ="ff" )
}