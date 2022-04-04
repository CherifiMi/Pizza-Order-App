package com.example.pizzaorderapp.ui.screens.choose.components

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

@ExperimentalAnimationApi
@ExperimentalMotionApi
@Composable
fun UnderLayer(mainViewModel: MainViewModel) {
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
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                GoBackToTopLayer({
                    mainViewModel.firstmode.value = true
                })
                PizzaTitle("Margherita Pizza")
                Raiting(80)
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .weight(50f),
            visible = !mainViewModel.firstmode.value,
            enter =  slideInVertically(),
            exit =  slideOutVertically()+ shrinkOut()
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ){
                PizzaImg(mainViewModel)
                SizeSlider(mainViewModel)
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .weight(35f),
            visible = !mainViewModel.firstmode.value,
            enter =  fadeIn(),
            exit =  fadeOut()
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
            ){
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    SizeName(mainViewModel)
                    Spacer(modifier = Modifier.height(70.dp))
                    QuantityPicker(mainViewModel)
                    Spacer(modifier = Modifier.height(70.dp))
                    PlaceOrderBtn (
                        {
                            Log.d("HILLO", "hi")
                        }
                    )
                }
            }
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
                        0f-> mainViewModel.sizename.value ="Small"
                        0.5f->mainViewModel.sizename.value ="Medium"
                        1.0f->mainViewModel.sizename.value ="Large"
                        else -> {mainViewModel.sizename.value ="Small"}
                    }
                },
                steps = 1
            )
        }
    }
}



@ExperimentalMotionApi
@Composable
fun PizzaImg(mainViewModel: MainViewModel) {

    //_____________
    val indvalue: Float = mainViewModel.sizeprogress.value

    val animatedIndVal = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(key1 = indvalue){
        animatedIndVal.animateTo(indvalue)
    }
    //_____________

    val context = LocalContext.current

    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = animatedIndVal.value,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pizza),
            contentDescription = "pizza",
            modifier = Modifier
                .clip(CircleShape)
                .layoutId("pizza_pic")
        )
    }
}

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