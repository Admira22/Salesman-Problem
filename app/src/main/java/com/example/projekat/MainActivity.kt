package com.example.projekat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projekat.ui.theme.ProjekatTheme

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekatTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjekatTheme {
        Meni()
    }
}