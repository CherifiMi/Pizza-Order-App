package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pizzaorderapp.ui.theme.MyWhite
import com.example.pizzaorderapp.ui.theme.heebo
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun SizeName(mainViewModel: MainViewModel) {
    Text(
        text = mainViewModel.sizename.value ,
        color = MyWhite,
        fontFamily = heebo,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )
}