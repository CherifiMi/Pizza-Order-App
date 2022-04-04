package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzaorderapp.R

@Composable
fun GoBackToTopLayer(clicked:()->Unit) {
    Row{
        IconButton(onClick = { clicked() }, Modifier.padding(8.dp,0.dp)) {
            Image(painter = painterResource(id = R.drawable.goback), contentDescription = "goback")
        }
    }
}