package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.ui.theme.Yellow
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun SmallCards(mainViewModel: MainViewModel) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxSize()
            .offset(0.dp, (-48).dp)
    ){
        for(i in 1..mainViewModel.pizzaListSize.value){
            Card(
                backgroundColor = Yellow ,
                shape = RoundedCornerShape(100),
                modifier = Modifier
                    .width(24.dp)
                    .height(6.dp)
                    .padding(4.dp, 0.dp)
                    .alpha(
                        when (i) {
                            mainViewModel.currentpizza.value -> 1f
                            else -> 0.5f
                        }
                    )
            ){}
        }
    }
}