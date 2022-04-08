package com.example.pizzaorderapp.viewModel

import android.app.Application
import android.util.Log
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

    //----------------values
    var allPizza = mutableListOf<Pizza>()

    var firstmode = mutableStateOf(true)
    var sizeprogress = mutableStateOf(0f)
    var pizzaQuantity = mutableStateOf(1)
    var sizename = mutableStateOf("Small")

    var currentpizza = mutableStateOf(1)
    var pizzaListSize = mutableStateOf(1)


    fun resetData(){
        firstmode.value = true
        sizeprogress.value = 0f
        pizzaQuantity.value = 1
        sizename.value = "Small"
        currentpizza.value = 1
        price.value = price1.value

        setData()

    }

    val name = mutableStateOf("")
    val description = mutableStateOf("")
    val price1 = mutableStateOf(0)
    val price2 = mutableStateOf(0)
    val price3 = mutableStateOf(0)

    val price = mutableStateOf(0)

    val pic_url = mutableStateOf("")
    val ingredients = mutableStateOf(listOf(""))
    val rating = mutableStateOf(0f)


    fun setData(){
        pizzaListSize.value = allPizza.size
        price.value = allPizza[currentpizza.value-1].price1


        name.value = allPizza[currentpizza.value-1].name
        description.value = allPizza[currentpizza.value-1].description
        price1.value = allPizza[currentpizza.value-1].price1
        price2.value = allPizza[currentpizza.value-1].price2
        price3.value = allPizza[currentpizza.value-1].price3
        pic_url.value = allPizza[currentpizza.value-1].pic_url
        ingredients.value = allPizza[currentpizza.value-1].ingredients
        rating.value = allPizza[currentpizza.value-1].rating

    }


    fun addPizza(){

        allPizza.add(Pizza(
            1,
            "Margherita",
            "fwrwfeaf is simply dummy text of the printing and typesetting industry typesetting industry.  including versions of Lorem .",
            1055,2055,3055,
            "https://www.vegrecipesofindia.com/wp-content/uploads/2020/11/pizza-recipe-2-500x375.jpg",
            ingredients = listOf("wr","hiii","wr"),
            2.5f
            )
        )
        allPizza.add(Pizza(
            1,
            "Margherita Pizza Pizza",
            "hola dummy text of the printing and typesetting industry typesetting industry.  including versions of Lorem .",
            1066,2066,3066,
            "https://i.ibb.co/fFVmg2z/ball.png",
            ingredients = listOf("hiii","hiii","werwerwe"),
            2.5f
        )
        )
        allPizza.add(Pizza(
            1,
            "Pizza",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry typesetting industry.  including versions of Lorem .",
            1550,2220,3220,
            "https://www.recipetineats.com/wp-content/uploads/2020/05/Pepperoni-Pizza_5-SQjpg.jpg",
            ingredients = listOf("hiii","hiii","hiii"),
            3.5f
        )
        )

        Log.d("ListTest", allPizza.toString())
    }

}