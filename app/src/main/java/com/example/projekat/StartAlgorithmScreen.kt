package com.example.projekat

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.projekat.model.City
import com.example.projekat.repository.CityRepository

@Composable
fun StartAlgorithmScreen(cityId: Int) {
    val cityRepository = CityRepository()
    val city = cityRepository.getCityById(cityId)

    val algorithmStarted = remember { mutableStateOf(false) }
    val shortestRoute = remember { mutableStateOf(listOf<City>()) }

    city?.let { city ->
        if (!algorithmStarted.value) {
            Text(text = city.name)

            Button(
                onClick = {
                    algorithmStarted.value = true
                    val algorithm = Algoritam(cityId)

                    // Ovdje možete ažurirati shortestRoute sa dobivenim rezultatom iz algoritma
                    shortestRoute.value = algorithm.trenutnaNajkracaRuta
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp)

            ) {
                Text(text = "START ALGORITHM")
            }
        } else {
            // Algoritam je započeo, prikaži najkraću rutu

            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn {
                items(shortestRoute.value) { city ->
                    Text(text = city.name)
                }
            }
        }
    }
}
