package com.example.projekat


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun SetupNavGraph(
    navController: NavHostController
){
   NavHost(
       navController = navController,
       startDestination = Screen.Home.route
   ){
       composable(
           route = Screen.Home.route
       ){
           HomeScreenWithImage(navController = navController)
       }
       composable(
           route = Screen.Detail.route,
       ){
           DetailScreen()
       }
       composable(
           route = Screen.Menu.route,
       ){
           MenuScreen(navController = navController)
       }
       composable(
           route = Screen.List.route,
       ){
           ListScreen()
       }


   }
}