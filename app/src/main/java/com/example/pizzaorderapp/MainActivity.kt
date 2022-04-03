package com.example.pizzaorderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pizzaorderapp.navigation.Navigation
import com.example.pizzaorderapp.ui.theme.PizzaOrderAppTheme
import com.example.pizzaorderapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    private val mainViewModel: MainViewModel by viewModels()

    @ExperimentalMotionApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            PizzaOrderAppTheme {
                //navController = rememberNavController()
                //Navigation(navController = navController, mainViewModel)


                //--------------------------------
                val context = LocalContext.current
                val motionScene = remember {
                    context.resources
                        .openRawResource(R.raw.pizza_size)
                        .readBytes()
                        .decodeToString()
                }
                MotionLayout(
                    motionScene = MotionScene(content = motionScene),
                    progress = 100f,
                    modifier = Modifier.fillMaxSize()
                ){

                    Image(
                        painter = painterResource(id = R.drawable.pizza),
                        contentDescription = "pizza",
                        modifier = Modifier
                            .clip(CircleShape)
                            .layoutId("pizza_pic")
                    )
                }
                //--------------------------------
            }
        }
    }
}

