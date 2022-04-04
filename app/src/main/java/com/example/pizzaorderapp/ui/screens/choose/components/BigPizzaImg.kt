package com.example.pizzaorderapp.ui.screens.choose.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pizzaorderapp.ui.theme.Blue1
import com.example.pizzaorderapp.viewModel.MainViewModel

@Composable
fun BigPizzaImg(mainViewModel: MainViewModel) {

    var x = 0

    Image(
        modifier = Modifier
            .pointerInput(Unit) {
                detectHorizontalDragGestures(



                    onHorizontalDrag = { change, dragAmount ->
                        change.consumeAllChanges()
                        x = dragAmount.toInt()
                                       },
                    onDragEnd = {
                        if(x>0){

                            if(mainViewModel.currentpizza.value>=1){
                                ma
                            }

                            Log.d("HILLODRAG", "SWIPE:3")
                        }else{
                            Log.d("HILLODRAG", "3:EPIWS")
                        }

                    }
                )
                //detectHorizontalDragGestures { change, dragAmount ->
                //    change.consumeAllChanges()
                //}
            }
            .offset(0.dp, (-160).dp)
            .scale(1.3f)
            .clip(CircleShape)
            .fillMaxSize(),
        contentScale = ContentScale.FillWidth,
        painter = rememberAsyncImagePainter(mainViewModel.pic_url.value),
        contentDescription ="ff" )
}