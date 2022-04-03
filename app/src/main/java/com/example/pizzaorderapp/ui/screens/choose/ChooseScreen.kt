package com.example.pizzaorderapp.ui.screens.choose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pizzaorderapp.navigation.Screens
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun ChooseScreen(navController: NavHostController, mainViewModel: MainViewModel) {



    mainViewModel.addPizza()

    Log.d("PIZZATEST", mainViewModel.allPizza.toString())
    Log.d("PIZZATEST", "hi")

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .clickable {
                navController.navigate(route = Screens.Payment.passOrder(
                    3,
                    1400,
                    "Mitooooooooooo"
                ))
            }
            .background(Color.White)
            .padding(32.dp, 16.dp)
            .height(104.dp)
            .fillMaxWidth()

    ){}

}