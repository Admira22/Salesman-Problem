package com.example.projekat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.projekat.model.City
import com.example.projekat.repository.CityRepository
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Composable
fun StartAlgorithmScreen(cityId: Int,navController: NavController) {
    val cityRepository = CityRepository()
    val city = cityRepository.getCityById(cityId)

    val algorithmStarted = remember { mutableStateOf(false) }
    val shortestRoute = remember { mutableStateOf(listOf<City>()) }

    city?.let { city ->
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.description),
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            Text(
                text = city.name,
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }


        if (!algorithmStarted.value) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Button(
                        onClick = {
                            algorithmStarted.value = true
                            val algorithm = Algoritam(cityId)
                            shortestRoute.value = algorithm.trenutnaNajkracaRuta
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()

                    ) {
                        Text(stringResource(id = R.string.startA))
                    }
                }
            }
        } else {
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    val routeText = buildRouteText(shortestRoute.value)
                    Row (
                        modifier = Modifier.background(MaterialTheme.colors.primary)
                            ){
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(fontSize = 20.sp)
                                ) {
                                    append(routeText)
                                }
                            },
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textDecoration = TextDecoration.None
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            val Gradovi = shortestRoute.value
                            val moshi = Moshi.Builder()
                                .addLast(KotlinJsonAdapterFactory())
                                .build()

                            val jsonAdapter: JsonAdapter<List<City>> = moshi.adapter<List<City>>(
                                Types.newParameterizedType(List::class.java, City::class.java)
                            )
                            val gradoviJson: String = jsonAdapter.toJson(Gradovi)

                            if (city != null) {
                                navController.navigate("${Screen.SeeRoute.route}/${city.id}/${gradoviJson}")
                            }
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "SEE PATH ON MAP")
                    }
                }
            }
        }
    }
}

private fun buildRouteText(cities: List<City>): String {
    val stringBuilder = StringBuilder()
    cities.forEachIndexed { index, city ->
        stringBuilder.append(city.name)
         if (index < cities.size - 1) {
             stringBuilder.append("->")
          }
        }
        return stringBuilder.toString()
}


