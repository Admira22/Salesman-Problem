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
                description = "Sarajevo, capital of Bosnia and Herzegovina, is a compact city on the Miljacka River," +
                        " surrounded by the Dinaric Alps."
            ),
            City(
                id = 1,
                image = R.drawable.konjic,
                name = "Konjic",
                landitude = 43.651409,
                longitude = 17.961691,
                description = "Konjic is a city and municipality located in the Herzegovina-Neretva Canton." +
                        "The city is one of the oldest permanent settlements in Bosnia and Herzegovina, dating back almost 4,000 years."
            ),
            City(
                id = 2,
                image = R.drawable.mostar,
                name = "Mostar",
                landitude = 43.343777,
                longitude = 17.807758,
                description = "Mostar is a city in southern Bosnia and Herzegovina, straddling the Neretva River. " +
                        "It’s known for the iconic Stari Most (Old Bridge), a reconstructed medieval arched bridge."
            ),
            City(
                id = 3,
                image = R.drawable.tuzla,
                name = "Tuzla",
                landitude = 44.5375,
                longitude = 18.6735,
                description = "Tuzla is the third-largest city of Bosnia and Herzegovina and the administrative center of" +
                        " Tuzla Canton of the Federation of Bosnia and Herzegovina."
            ),
            City(
                id = 4,
                image = R.drawable.banjaluka,
                name = "Banja Luka",
                landitude = 44.7722,
                longitude = 17.1910,
                description = "Banja Luka is the second largest city in Bosnia and Herzegovina." +
                        "It is the traditional centre of the densely-forested Bosanska Krajina region of northwestern Bosnia."
            ),
            City(
                id = 5,
                image = R.drawable.bihac,
                name = "Bihać",
                landitude = 44.8120,
                longitude = 15.8686,
                description = "Bihać is a city and the administrative centre of Una-Sana Canton." +
                        " It is situated on the banks of river Una in northwestern Bosnia and Herzegovina, in the Bosanska Krajina region."
            ),

            )
    }
    fun getCityById(id: Int): City? {
        return getAllData().find { it.id == id }
    }

}