package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderapp.ui.theme.MyWhite
import com.example.pizzaorderapp.ui.theme.heebo

@Composable
fun PizzaTitle(name: String) {
    Text(
        modifier = Modifier.padding(32.dp,0.dp),
        maxLines = 1,
        text = name,
        color = MyWhite,
        fontFamily = heebo,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    )
}