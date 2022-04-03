package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pizzaorderapp.ui.theme.Blue1
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun TopLayer(mainViewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                mainViewModel.firstmode.value = true
            }
            .background(Blue1)
    ){

        Spacer(modifier = Modifier.weight(56f))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(44f)
        ) {
            BottomInfoSheet(mainViewModel)
        }

    }
}