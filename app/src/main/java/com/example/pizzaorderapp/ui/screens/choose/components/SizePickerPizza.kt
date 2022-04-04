package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ExperimentalMotionApi
import com.example.pizzaorderapp.viewModel.MainViewModel

@ExperimentalMotionApi
@Composable
fun SizePickerPizza(mainViewModel: MainViewModel) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ){
        PizzaImg(mainViewModel)
        SizeSlider(mainViewModel)
    }
}