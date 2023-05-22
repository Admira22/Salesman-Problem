package com.example.projekat
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailScreen(){
    Column{
        val configuration = LocalConfiguration.current
        val image = painterResource(id = R.drawable.image2)
        when (configuration.orientation){
            Configuration.ORIENTATION_PORTRAIT ->{
                Image(
                    painter = image,
                    contentDescription = null,
                )
                Text(
                    text = stringResource(R.string.title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)

                )
                Text(
                    text = stringResource(R.string.intro),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
                Text(
                    text = stringResource(R.string.text),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
            else ->
            {
                Text(
                    text = stringResource(R.string.title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)

                )
                Text(
                    text = stringResource(R.string.intro),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
                Text(
                    text = stringResource(R.string.text),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 16.dp)
                )
            }
        }

    }
}
@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen()
}