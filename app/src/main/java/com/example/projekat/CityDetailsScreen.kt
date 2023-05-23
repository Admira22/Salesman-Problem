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

@Composable
fun CityDetailScreen(city: City,navController: NavController) {
    Column {
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
            onClick = { navController.navigate(route = Screen.CityDetails.route) },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            modifier = Modifier
                .height(50.dp)
                .width(400.dp)
        ) {
            Text(
                text = stringResource(R.string.seemap),

                )
        }

    }
}
@Composable
@Preview(showBackground = true)
fun CityDetailPreview() {
    CityDetailScreen(
        city = City(
            id = 0,
            image = R.drawable.sarajevo,
            name = "Sarajevo",
            landitude = 44.8120,
            longitude = 15.8686,
            description = "bla bla bla bla"

        ),
        navController = rememberNavController()
    )
}
