package com.example.pizzaorderapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pizzaorderapp.ui.screens.choose.ChooseScreen
import com.example.pizzaorderapp.ui.screens.payment.PaymentScreen
import com.example.pizzaorderapp.viewModel.MainViewModel


@Composable
fun Navigation(
    navController: NavHostController,
    mainViewModel: MainViewModel
){

    NavHost(navController, startDestination = Screens.Choose.route) {

        composable(route = Screens.Choose.route) {
            ChooseScreen(navController, mainViewModel)
        }

        composable(
            route = Screens.Payment.route,
            arguments = listOf(
                navArgument("quantity") {type = NavType.IntType},
                navArgument("price") {type = NavType.IntType},
                navArgument("pizza") {type = NavType.StringType},
            )
        )
        {
            var args = it.arguments
            PaymentScreen(navController, args, mainViewModel)

        }
    }

}