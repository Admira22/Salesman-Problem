package com.example.projekat


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun RouteScreen(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.image2)
    val textState1 = Color.Red
    val textState2 = Color.Blue
    var selectedOption by remember { mutableStateOf(textState1) }
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
        TextField(
            value = "pick the city",
            onValueChange ={},
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
                .padding(top = 32.dp)
        )
        TextField(
            value = "pick another one",
            onValueChange ={},
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
                .padding(top = 32.dp)
        )
        Button(
            onClick = {
                println("Button Clicked!")
            },
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
                .padding(top = 32.dp)
        ) {
            Text("Submit")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RouteScreenPreview() {
    RouteScreen()
}
