package com.example.projekat


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projekat.model.City
import com.example.projekat.repository.CityRepository

@Composable
fun CityDetailScreen(cityId: Int, navController: NavController) {
    val cityRepository = CityRepository()
    val city = cityRepository.getCityById(cityId)

    Column {
        city?.let { city ->
            val image = painterResource(id = city.image)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color.LightGray)
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Text(
                text = city.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            )
            Text(
                text = "${city.landitude}",
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = city.description,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
            )
            Button(
                onClick = { navController.navigate("${Screen.Map.route}/${city.id}") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp)
            ) {
                Text(
                    text = stringResource(R.string.seemap),
                )
            }
            Button(
                onClick = { navController.navigate("${Screen.StartAlgorithm.route}/${city.id}") },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
                modifier = Modifier
                    .height(50.dp)
                    .width(400.dp)
            ) {
                Text(
                    text = stringResource(R.string.algorithm),
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CityDetailPreview() {
    CityDetailScreen(
        cityId = 0,
        navController = rememberNavController()
    )
}
