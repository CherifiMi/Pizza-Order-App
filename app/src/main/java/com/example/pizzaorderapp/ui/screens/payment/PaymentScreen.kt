package com.example.pizzaorderapp.ui.screens.payment

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun PaymentScreen(
    navController: NavHostController,
    args: Bundle?, mainViewModel: MainViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ){

        Text(
            modifier = Modifier.clickable {
                navController.popBackStack()
            },
            text = args?.getInt("quantity").toString(),
            fontSize = 50.sp)
        Text(
            modifier = Modifier.clickable {
                navController.popBackStack()
            },
            text = args?.getInt("price").toString(),
            fontSize = 50.sp)
        Text(
            modifier = Modifier.clickable {
                navController.popBackStack()
            },
            text = args?.getString("pizza").toString(),
            fontSize = 50.sp)

    }
}