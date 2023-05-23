package com.example.projekat

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = stringResource(R.string.menu),
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h3.fontSize,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(top = 20.dp)

        )
        Button(
            onClick = { navController.navigate(route = Screen.Route.route)},
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .padding(top = 32.dp)
        ) {
            Text(
                text = stringResource(R.string.findroute),
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        Button(
            onClick = { navController.navigate(route = Screen.List.route)},
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .padding(top = 32.dp)
        ) {
            Text(
                text = stringResource(R.string.cites),
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        Button(
            onClick = { navController.navigate(route = Screen.Detail.route)},
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
                .padding(top = 32.dp)
        ) {
            Text(
                text = stringResource(R.string.about),
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    }
}
@Composable
@Preview(showBackground = true)
fun Meni() {
    Column(modifier = Modifier.fillMaxSize()) {
    }
}