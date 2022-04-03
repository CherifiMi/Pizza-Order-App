package com.example.pizzaorderapp.ui.screens.choose

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.navigation.NavHostController
import com.example.pizzaorderapp.ui.screens.choose.components.TopLayer
import com.example.pizzaorderapp.ui.screens.choose.components.UnderLayer
import com.example.pizzaorderapp.viewModel.MainViewModel

//navController.navigate(route = Screens.Payment.passOrder(
//    3,
//    1400,
//    "Mitooooooooooo"
//))

@ExperimentalMotionApi
@Composable
fun ChooseScreen(navController: NavHostController, mainViewModel: MainViewModel) {

    Box(Modifier.fillMaxSize()){
        UnderLayer(mainViewModel)
        //TopLayer(mainViewModel)
    }
}







