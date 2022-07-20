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
        allPizza.addAll(
            listOf(

                Pizza(
                    1,
                    "Blue Cheese Pizza",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." ,
                    2055,3200,6000,
                    "https://i.ibb.co/2NFw5F4/image-5.png",
                    ingredients = listOf("Olives","Tomato","Grass", "Blue Cheese"),
                    3.7f
                ),
                Pizza(
                    2,
                    "Sosig Pizza",
                    "t is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here,",
                    1900,3080,3505,
                    "https://i.ibb.co/XYYyBfD/image-6.png",
                    ingredients = listOf("Cheese","Sosig"),
                    3f
                ),
                Pizza(
                    3,
                    "Onion Pizza",
                    "content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncove",
                    1111,2222,9999,
                    "https://i.ibb.co/xgyp30n/image-7.png",
                    ingredients = listOf("Greens","Onions","Chees", "Tomato", "Black Olives"),
                    0f
                ),
                Pizza(
                    4,
                    "Margherita Pizza",
                    "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum",
                    1955,2655,2700,
                    "https://i.ibb.co/LkC8zjy/Rectangle-11.png",
                    ingredients = listOf("Things","Stuff","Hi"),
                    3f
                ),
                Pizza(
                    5,
                    "Pepper Pizza",
                    "d and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.",
                    1599,2099,2200,
                    "https://i.ibb.co/2kGKT8Z/image-4.png",
                    ingredients = listOf("Oil","Pepper","Cheese", "Honey"),
                    2.8f
                ),
            )
        )
    }

}