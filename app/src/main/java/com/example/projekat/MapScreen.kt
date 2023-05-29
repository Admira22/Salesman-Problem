package com.example.projekat

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.projekat.repository.CityRepository
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(cityId: Int) {
    val cityRepository = CityRepository()
    val city = cityRepository.getCityById(cityId)

    city?.let { city ->
        val grad=LatLng(city.landitude,city.longitude)

        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(grad, 10f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = grad),
                title = city.name,
                //snippet = "Sebilj"
            )
        }
    }

}

