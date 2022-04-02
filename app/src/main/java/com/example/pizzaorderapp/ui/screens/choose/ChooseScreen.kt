package com.example.pizzaorderapp.ui.screens.choose

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun ChooseScreen(navController: NavHostController, mainViewModel: MainViewModel) {



    mainViewModel.addPizza()

    Log.d("PIZZATEST", mainViewModel.allPizza.toString())
    Log.d("PIZZATEST", "hi")

}