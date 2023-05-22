package com.example.projekat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projekat.model.City

@Composable
fun CustomItem(city: City,navController: NavController,modifier: Modifier = Modifier){
    val image = painterResource(id = city.image)
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        //horizontalArrangement = Arrangement.spacedBy(1.dp)
    ) {

        Image(painter = image,
            modifier = modifier
                .size(100.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(50)),
            contentScale = ContentScale.Crop,
            contentDescription = null)
        Text(
            modifier = modifier
                .padding(start = 20.dp),
            text = city.name,
            color = Color.Black,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = { navController.navigate(route = Screen.Menu.route)},
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .padding(top = 32.dp)
        ) {
            Text(
                text = stringResource(R.string.seemore),
                fontSize = MaterialTheme.typography.h6.fontSize
            )
        }
    }
}
