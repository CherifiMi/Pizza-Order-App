package com.example.pizzaorderapp.ui.screens.choose

import android.content.res.Resources
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.NavHostController
import com.example.pizzaorderapp.navigation.Screens
import com.example.pizzaorderapp.ui.theme.Blue1
import com.example.pizzaorderapp.ui.theme.Blue2
import com.example.pizzaorderapp.ui.theme.Shapes
import com.example.pizzaorderapp.ui.theme.heebo
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun ChooseScreen(navController: NavHostController, mainViewModel: MainViewModel) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            //.clickable {
            //    navController.navigate(route = Screens.Payment.passOrder(
            //        3,
            //        1400,
            //        "Mitooooooooooo"
            //    ))
            //}
            .background(Blue1)
    ){

        Spacer(modifier = Modifier.weight(56f))


        ButtomInfoSheet()



    }

}

@Composable
fun ColumnScope.ButtomInfoSheet() {
    Card(
        Modifier
            .fillMaxWidth()
            .weight(44f)
            .fillMaxHeight()
            .clip(
                RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)
            )
    ){
        Column(
            Modifier.background(Blue2)
        ){
            Text(
                modifier = Modifier.padding(32.dp,16.dp),
                text = "Margherita Pizza",
                color = Color.White,
                fontFamily = heebo,
                fontWeight = FontWeight.Normal,
                fontSize = 32.sp)
        }
    }
}