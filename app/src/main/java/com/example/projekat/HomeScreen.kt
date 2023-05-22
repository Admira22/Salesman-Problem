package com.example.projekat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(){
    Column{
        Text(
            text = stringResource(R.string.welcome),
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h3.fontSize,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colors.primary
        )
        Text(
            text = stringResource(R.string.subtitle),
            fontSize = MaterialTheme.typography.h5.fontSize,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            color = MaterialTheme.colors.primaryVariant,


        )
    }
}
@Composable
fun HomeScreenWithImage(navController: NavController,modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.image2)
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = image,
            modifier = modifier
                .size(200.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(50)),
            contentScale = ContentScale.Crop,
            contentDescription = null)
        HomeScreen()
        Button(
            onClick = { navController.navigate(route = Screen.Menu.route)},
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .padding(top = 32.dp)
        ) {
            Text(
                text = stringResource(R.string.start),
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreenWithImage(
        navController = rememberNavController()
    )
}