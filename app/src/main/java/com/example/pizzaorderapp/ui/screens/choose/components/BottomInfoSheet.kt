package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaorderapp.ui.screens.choose.*
import com.example.pizzaorderapp.ui.theme.*
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun BottomInfoSheet(mainViewModel: MainViewModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .drawBehind {
                drawRoundRect(
                    color = Color.Black,
                    cornerRadius = CornerRadius(60f),
                    topLeft = Offset(2f, -3f),
                    alpha = .1f
                )
            }
            .clip(
                RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp)
            )
    ){
        Column(
            Modifier
                .background(Blue2)
                .padding(0.dp)
        ){
            PizzaName("Margherita Pizza")

            val ings = listOf("hisfsdfsdf","hidsfsdf","hsdfsfsdfi","hsfddsfsfsdi","hsfddsfsfsdi")
            PizzaIng(ings)
            PizzaPrice(1399)
            PizzaDec("Lorem Ipsum is Lorem Ipsum is simply dummy text of the printing and typesetting industry typesetting industry.  including versions of Lorem .")

            AddToCartBtn({
                mainViewModel.currentpizza.value +=1
                mainViewModel.firstmode.value = false
            })


        }
    }
}

@Composable
fun PizzaName(name: String) {
    Text(
        modifier = Modifier.padding(32.dp,16.dp),
        text = name,
        color = MyWhite,
        fontFamily = heebo,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    )
}

@Composable
fun PizzaIng(ings: List<String>) {
    Row (
        Modifier
            .padding(40.dp, 0.dp)
            .horizontalScroll(
                rememberScrollState()
            ),
        horizontalArrangement = Arrangement.Start
    ){
        for (ing in ings){
            Card(
                Modifier
                    .clip(
                        RoundedCornerShape(30)
                    )
                    .drawBehind {
                        drawRect(
                            color = Gray
                        )
                    }
                    .wrapContentSize()
                    .background(Blue2)
            ){
                Text(
                    modifier = Modifier
                        .padding(10.dp, 4.dp),
                    text = ing,
                    color = MyDimWhite,
                    fontFamily = heebo,
                    fontWeight = FontWeight.Bold,
                    fontSize = 11.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}

@Composable
fun PizzaPrice(p: Int) {
    Text(
        modifier = Modifier.padding(36.dp,24.dp,36.dp,24.dp),
        text = "${p.toFloat()/100f}$",
        color = Yellow,
        fontFamily = heebo,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}

@Composable
fun PizzaDec(d: String) {
    Box(
        contentAlignment = Alignment.TopStart,
        modifier = Modifier
            .height(110.dp)
            .fillMaxHeight()
    ){
        Text(
            modifier = Modifier.padding(32.dp,0.dp),
            text = d,
            color = Dec,
            fontFamily = heebo,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun AddToCartBtn(clicked:()->Unit) {
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