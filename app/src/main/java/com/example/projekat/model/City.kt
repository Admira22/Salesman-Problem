package com.example.projekat.model

import androidx.annotation.DrawableRes

data class City(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val longitude: Double,
    val landitude: Double,
    val description: String

)