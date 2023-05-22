package com.example.projekat.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class City(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val longitude: Double,
    val landitude: Double

)