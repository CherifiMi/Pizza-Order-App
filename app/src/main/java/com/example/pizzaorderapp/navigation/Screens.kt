package com.example.pizzaorderapp.navigation

import com.example.pizzaorderapp.data.models.Pizza

sealed class Screens(val route: String) {
    object Choose: Screens(route = "choose_screen")

    object Payment: Screens(route = "payment_screen/{quantity}/{price}/{pizza}"){
        fun passOrder(quantity: Int, price: Int, pizza: String): String{
            return "payment_screen/$quantity/$price/$pizza"
        }
    }
}