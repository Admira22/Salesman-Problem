package com.example.projekat.model

import androidx.annotation.DrawableRes
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

data class City(
    val id: Int,
    @DrawableRes val image: Int,
    val name: String,
    val longitude: Double,
    val landitude: Double,
    val description: String
){
    private fun URadijane(stepeni:Double):Double{
        return (Math.PI/180)*stepeni
    }
    fun izracunajUdaljenost(grad:City):Double{
        val lat1=URadijane(this.landitude)
        val long1=URadijane(this.longitude)
        val lat2=URadijane(grad.landitude)
        val long2=URadijane(grad.longitude)

        val dlong=long2-long1
        val dlat=lat2-lat1
        val R=6371
        var rezultat=Math.pow(sin(dlat/2),2.0)+ cos(lat1) * cos(lat2) *Math.pow(sin(dlong/2),2.0)
        rezultat= asin(sqrt(rezultat))
        rezultat *= R
        return rezultat

    }
}
