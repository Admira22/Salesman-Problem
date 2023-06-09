package com.example.projekat

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.projekat.ui.theme.ProjekatTheme
import kotlinx.coroutines.launch
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjekatTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        AppBar(
                            onNavigationIconClick = {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            },
                            onShareClicked = {
                                shareContent()
                            }
                        )
                    },
                    drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    contentDescription = "Go to home screen",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "list",
                                    title = "List of cites",
                                    contentDescription = "Go to list of cites",
                                    icon = Icons.Default.List
                                ),
                                MenuItem(
                                    id = "info",
                                    title = "Info",
                                    contentDescription = "Get help",
                                    icon = Icons.Default.Info
                                ),
                            ),
                            onItemClick = {
                                when(it.id){
                                    "home"  -> {
                                        navController.navigate(route = Screen.Home.route)
                                               }
                                    "list" -> {
                                        navController.navigate(route = Screen.List.route)
                                    }
                                    "info" -> {
                                        navController.navigate(route = Screen.Detail.route)
                                    }
                                }
                            }
                        )
                    },
                ) {
                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)

                }


            }
        }
    }
    private fun shareContent() {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "Shared Content")
            putExtra(Intent.EXTRA_TEXT, "Content to share")
        }

        startActivity(Intent.createChooser(intent, "Share via"))
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjekatTheme {
        Meni()
    }
}