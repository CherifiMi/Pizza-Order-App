package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderapp.ui.theme.MyWhite
import com.example.pizzaorderapp.ui.theme.Red
import com.example.pizzaorderapp.ui.theme.heebo

@Composable
fun PlaceOrderBtn(clicked:()->Unit) {
    Card(
        shape = RoundedCornerShape(100.dp),
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .padding(32.dp, 0.dp, 32.dp, 0.dp)
    ) {
        Button(
            onClick = {clicked()},
            colors = ButtonDefaults.buttonColors(backgroundColor = Red)
        ){
            Text(
                text ="Add to Cart",
                color = MyWhite,
                fontFamily = heebo,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
        }
    }
}