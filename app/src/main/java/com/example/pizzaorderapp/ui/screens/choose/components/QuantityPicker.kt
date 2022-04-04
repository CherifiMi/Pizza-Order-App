package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ui.theme.Blue1
import com.example.pizzaorderapp.ui.theme.MyWhite
import com.example.pizzaorderapp.ui.theme.Red
import com.example.pizzaorderapp.ui.theme.heebo
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun QuantityPicker(mainViewModel: MainViewModel) {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(32.dp, 0.dp, 0.dp, 0.dp),
            text = "Quantity",
            color = MyWhite,
            fontFamily = heebo,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
        Card(
            backgroundColor = Blue1 ,
            shape = RoundedCornerShape(100),
            border = BorderStroke(
                1.dp, MyWhite
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp, 0.dp)
        ){
            Row (horizontalArrangement = Arrangement.SpaceBetween){
                IconButton(
                    modifier = Modifier.offset((-4).dp,0.dp),
                    onClick = { if(mainViewModel.pizzaQuantity.value >= 2){
                        mainViewModel.pizzaQuantity.value -= 1
                    }
                    }
                ) {
                    Image(painter = painterResource(id = R.drawable.minbtn), contentDescription = "")
                }
                Text(
                    text = mainViewModel.pizzaQuantity.value.toString(),
                    color = Red,
                    fontFamily = heebo,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                IconButton(
                    modifier = Modifier.offset((4).dp,0.dp),
                    onClick = { mainViewModel.pizzaQuantity.value += 1 }
                ) {
                    Image(painter = painterResource(id = R.drawable.plsbtn), contentDescription = "")
                }
            }
        }
    }
}