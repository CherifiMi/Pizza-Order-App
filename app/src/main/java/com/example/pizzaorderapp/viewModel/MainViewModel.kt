package com.example.pizzaorderapp.viewModel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pizzaorderapp.data.models.Pizza
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application
): AndroidViewModel(application)
{

    var firstmode = mutableStateOf(true)
    var sizeprogress = mutableStateOf(0f)
    var pizzaQuantity = mutableStateOf(1)
    var sizename = mutableStateOf("Small")

    var currentpizza = mutableStateOf(2)
    var pizzaListSize = mutableStateOf(7)

    var allPizza = mutableListOf<Pizza>()

    fun resetData(){
        firstmode.value = true
        sizeprogress.value = 0f
        pizzaQuantity.value = 1
        sizename.value = "Small"
        currentpizza.value = 1
        price.value = price1.value
    }

    val name = mutableStateOf("My Pizza")
    val description = mutableStateOf("HIIIIIIII Ipsum is simply dummy text of the printing and typesetting industry typesetting industry.  including versions of Lorem .",)
    val price1 = mutableStateOf(1000)
    val price2 = mutableStateOf(2000)
    val price3 = mutableStateOf(3000)

    val price = mutableStateOf(1000)

    val pic_url = mutableStateOf("https://i.ibb.co/fFVmg2z/ball.png")
    val ingredients = mutableStateOf(listOf("Cheese","Pizza","Potato"))
    val rating = mutableStateOf(1)


    fun addPizza(){
        allPizza.add(Pizza(
            1,
            "Margherita Pizza",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry typesetting industry.  including versions of Lorem .",
            10,20,30,
            "",
            ingredients = listOf("hiii","hiii","hiii"),
            2.5f
            )
        )
    }

    //val task = tasks.find { it.id == id?.toInt() }
}