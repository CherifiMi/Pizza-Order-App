package com.example.pizzaorderapp.ui.screens.choose.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.pizzaorderapp.R
import com.example.pizzaorderapp.viewModel.MainViewModel

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