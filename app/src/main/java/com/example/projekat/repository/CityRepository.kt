package com.example.projekat.repository

import com.example.projekat.R
import com.example.projekat.model.City

class CityRepository {
    fun getAllData(): List<City>{
        return listOf(
            City(
                id = 0,
                image = R.drawable.sarajevo,
                name = "Sarajevo",
                landitude = 43.856258,
                longitude = 18.413076,
                description = "bla bla bla bla"
            ),
            City(
                id = 1,
                image = R.drawable.konjic,
                name = "Konjic",
                landitude = 43.651409,
                longitude = 17.961691,
                description = "bla bla bla bla"
            ),
            City(
                id = 2,
                image = R.drawable.mostar,
                name = "Mostar",
                landitude = 43.343777,
                longitude = 17.807758,
                description = "bla bla bla bla"
            ),
            City(
                id = 3,
                image = R.drawable.tuzla,
                name = "Tuzla",
                landitude = 44.5375,
                longitude = 18.6735,
                description = "bla bla bla bla"
            ),
            City(
                id = 4,
                image = R.drawable.banjaluka,
                name = "Banja Luka",
                landitude = 44.7722,
                longitude = 17.1910,
                description = "bla bla bla bla"
            ),
            City(
                id = 5,
                image = R.drawable.bihac,
                name = "Bihać",
                landitude = 44.8120,
                longitude = 15.8686,
                description = "bla bla bla bla"
            ),

        )
    }
    fun getCityById(id: Int): City? {
        return getAllData().find { it.id == id }
    }

}