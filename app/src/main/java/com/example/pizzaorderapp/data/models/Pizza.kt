package com.example.pizzaorderapp.data.models

data class Pizza(
    val id: Int = 0,
    val name: String,
    val description: String,
    val price1: Int,
    val price2: Int,
    val price3: Int,
    val pic_url: String,
    val ingredients: List<String>,
    val rating: Float,
)