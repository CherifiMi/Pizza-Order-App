package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ui.theme.Red
import com.example.pizzaorderapp.viewModel.MainViewModel


@Composable
fun SizeSlider(mainViewModel: MainViewModel) {

    Box(contentAlignment = Alignment.CenterEnd, modifier = Modifier.fillMaxSize()) {
        Row() {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .offset(0.dp, 7.dp)
                    .weight(1f)
                    .padding(5.dp, 0.dp),
                contentScale = ContentScale.FillWidth,
                painter = painterResource(id = R.drawable.slidersteps),
                contentDescription ="ff" )
        }

        Row() {
            Spacer(modifier = Modifier.weight(1f))

            var progress by remember {
                mutableStateOf(0f)
            }

            Slider(
                modifier = Modifier
                    .weight(1f),
                colors = SliderDefaults.colors(
                    thumbColor = Red,
                    activeTrackColor = Color.Transparent,
                    inactiveTrackColor = Color.Transparent
                ),
                value = progress,
                onValueChange = {progress = it},
                onValueChangeFinished = {
                    mainViewModel.sizeprogress.value = progress
                    when(progress){
                        0f-> {
                            mainViewModel.price.value = mainViewModel.price1.value
                            mainViewModel.sizename.value = "Small"
                        }
                        0.5f-> {
                            mainViewModel.price.value = mainViewModel.price2.value
                            mainViewModel.sizename.value = "Medium"
                        }
                        1.0f-> {
                            mainViewModel.price.value = mainViewModel.price3.value
                            mainViewModel.sizename.value = "Large"
                        }
                        else -> {
                            mainViewModel.price.value = mainViewModel.price1.value
                            mainViewModel.sizename.value ="Small"
                        }
                    }
                },
                steps = 1
            )
        }
    }
}