package com.example.projekat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.projekat.model.City
import com.example.projekat.repository.CityRepository
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


@Composable
fun SeeRouteScreen(cityId: Int, gradoviJson: String) {
    val cityRepository = CityRepository()
    val city = cityRepository.getCityById(cityId)
    val gradovi = parseGradoviFromJson(gradoviJson)

    city?.let { city ->
        val grad = LatLng(city.landitude, city.longitude)

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(grad, 10f)
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
        ) {
            Marker(
                state = MarkerState(position = grad),
                title = city.name,
            )
            DrawRoute(gradovi = gradovi, cityRepository =cityRepository, startGrad = city)
        }
    }

}
@Composable
fun DrawRoute(gradovi: List<City>, cityRepository: CityRepository,startGrad:City) {
    //uzima listu svih gradova,kako bi ih uporedio sa rutom koja mu je proslijedjena i kako bi mogao
    //da dobije landitudu i longitutu
    val cityList = cityRepository.getAllData()

    //ovdje dodaje koordinate za gradove iz rute i stavlja ih u objekat LatLnG kako bi se moglo
    //proslijedit polyline da se iscrta jer ona kao parametar prima points koje su upravo tipa LatLng
    val gradoviWithCoordinates = gradovi.mapNotNull { grad ->
        cityList.find { it.name == grad.name }
    }.map { city ->
        LatLng(city.landitude, city.longitude)
    }

    if (gradoviWithCoordinates.isNotEmpty()) {
        //ovdje na kraj rute dodaje pocetni grad
        val gradoviWithStart = gradoviWithCoordinates + LatLng(startGrad.landitude, startGrad.longitude)
        Polyline(
            points = gradoviWithStart,
            color = Color.Black,
            width = 5f
        )
    }
}
private fun parseGradoviFromJson(gradoviJson: String): List<City> {
    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val listType = Types.newParameterizedType(List::class.java, City::class.java)
    val jsonAdapter: JsonAdapter<List<City>> = moshi.adapter(listType)
    return jsonAdapter.fromJson(gradoviJson) ?: emptyList()
}


