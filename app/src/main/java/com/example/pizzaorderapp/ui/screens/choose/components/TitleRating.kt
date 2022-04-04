package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun TitleRating(mainViewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxWidth()
    ){
        GoBackToTopLayer {
            mainViewModel.resetData()
        }
        PizzaTitle("Margherita Pizza")
        Raiting(mainViewModel.rating.value.toInt()*25)
    }
}