package com.example.pizzaorderapp.ui.screens.choose.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.ui.theme.*
import com.example.pizzaorderapp.viewModel.MainViewModel

@ExperimentalMotionApi
@Composable
fun UnderLayer(mainViewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                mainViewModel.firstmode.value = true
            }
            .background(Blue1)
    ){


        Spacer(modifier = Modifier.height(32.dp))

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxWidth()
                .weight(15f)
        ){
            GoBackToTopLayer({})
            PizzaTitle("Margherita Pizza")
            Raiting(80)
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(50f)
        ){
            PizzaImg(mainViewModel)
            //SizeSlider(mainViewModel)
        }


        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(35f)
        ){

        }

    }
}

@Composable
fun GoBackToTopLayer(clicked:()->Unit) {
    Row{
        IconButton(onClick = { clicked() }, Modifier.padding(8.dp,0.dp)) {
            Image(painter = painterResource(id = R.drawable.goback), contentDescription = "goback")
        }
    }
}

@Composable
fun PizzaTitle(name: String) {
    Text(
        modifier = Modifier.padding(32.dp,0.dp),
        text = name,
        color = MyWhite,
        fontFamily = heebo,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    )
}

@Composable
fun Raiting(r: Int) {
    Box(
        Modifier
            .wrapContentHeight()
            .padding(32.dp, 0.dp)
    ){
        Box(modifier = Modifier
            .height(20.dp)
            .width((r * 96 / 100).dp)
            .background(Yellow))
        Image(painter = painterResource(id = R.drawable.starmask), contentDescription = "hi")
    }
}

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
            Slider(
                modifier = Modifier
                    .weight(1f),
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = Yellow,
                    activeTrackColor = Color.Transparent,
                    inactiveTrackColor = Color.Transparent
                ),
                value = mainViewModel.sizeprogress.value,
                onValueChange = {
                    Log.d("TESTHILLO", mainViewModel.sizeprogress.toString())
                    mainViewModel.sizeprogress.value = it
                                },
                steps = 1)
        }
    }
}

/*
default: {
      from: 'start',
      to: 'end',
      pathMotionArc: 'startHorizontal',
      KeyFrames: {
        KeyAttributes: [
          {
            target: ['pizza_pic'],
            frames: [0,50,100],
            rotationZ: [0, 180, 360],

          }
        ]
      }
    }
 */

@ExperimentalMotionApi
@Composable
fun PizzaImg(mainViewModel: MainViewModel) {

    /*
            Image(
        modifier = Modifier.layoutId("pizza_pic"),
        painter = painterResource(id = R.drawable.pizza),
        contentDescription =""
    )
     */

}

@Composable
fun SizeName() {

}

@Composable
fun QuantityPicker() {

}

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