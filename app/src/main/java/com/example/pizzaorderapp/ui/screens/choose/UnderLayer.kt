package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.navigation.NavHostController
import com.example.pizzaorderapp.navigation.Screens
import com.example.pizzaorderapp.ui.theme.*
import com.example.pizzaorderapp.viewModel.MainViewModel

@ExperimentalAnimationApi
@ExperimentalMotionApi
@Composable
fun UnderLayer(mainViewModel: MainViewModel, navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Blue1)
    ){
        Spacer(modifier = Modifier.height(32.dp))

        AnimatedVisibility(
            modifier = Modifier
                .weight(15f),
            visible = !mainViewModel.firstmode.value,
            enter =  fadeIn(),
            exit =  fadeOut()
        ) {
            TitleRating(mainViewModel)
        }

        AnimatedVisibility(
            modifier = Modifier
                .weight(50f),
            visible = !mainViewModel.firstmode.value,
            enter =  slideInVertically(),
            exit =  slideOutVertically()+ fadeOut()
        ) {
            SizePickerPizza(mainViewModel)
        }

        AnimatedVisibility(
            modifier = Modifier
                .weight(35f),
            visible = !mainViewModel.firstmode.value,
            enter =  fadeIn(),
            exit =  fadeOut()
        ) {
            QuantityPickerPizza(
                mainViewModel
            ) {
                navController.navigate(
                    route = Screens.Payment.passOrder(
                        mainViewModel.pizzaQuantity.value,
                        mainViewModel.price.value,
                        mainViewModel.name.value
                    )
                )
                mainViewModel.resetData()
            }
        }
    }
}

