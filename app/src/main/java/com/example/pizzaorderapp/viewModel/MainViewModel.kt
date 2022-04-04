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

    val firstmode = mutableStateOf(true)

    var sizeprogress = mutableStateOf(0f)

    var allPizza = mutableListOf<Pizza>()



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