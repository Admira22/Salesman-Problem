package com.example.projekat


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun RouteScreen(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.image2)
    var text1 by remember { mutableStateOf("Enter a name of city...") }
    var text2 by remember { mutableStateOf("Enter a name of another city...") }
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
            value = text1,
            onValueChange ={newText ->
                text1 = newText
            },
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
                .padding(top = 32.dp)
        )
        TextField(
            value = text2,
            onValueChange ={newText ->
                text2 = newText
            },
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
