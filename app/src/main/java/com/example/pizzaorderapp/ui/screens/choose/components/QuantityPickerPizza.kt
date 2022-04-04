package com.example.pizzaorderapp.ui.screens.choose.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun QuantityPickerPizza(mainViewModel: MainViewModel, function: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
    ){
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            SizeName(mainViewModel)
            Spacer(modifier = Modifier.height(70.dp))
            QuantityPicker(mainViewModel)
            Spacer(modifier = Modifier.height(70.dp))
            PlaceOrderBtn ({function()})
        }
    }
}