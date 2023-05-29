package com.example.projekat


import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projekat.model.City


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
           ListScreen(navController = navController)
       }
       composable(
           route = Screen.CityDetails.route+"/{cityId}",
           arguments = listOf(navArgument("cityId"){
               type = NavType.IntType
           })
       ){
           val cityId=it.arguments?.getInt("cityId").toString()
           CityDetailScreen(cityId =cityId.toInt(),navController=navController)
       }
       composable(
           route = Screen.Route.route,
       ){
           RouteScreen()
       }
       composable(
           route = Screen.Map.route+"/{cityId}",
           arguments = listOf(navArgument("cityId"){
               type = NavType.IntType
           })
       ){
           /*MapScreen(city = City(
               id = 0,
               name = "Sarajevo",
               landitude = 14.234,
               longitude = 12.345,
               description = "bla bla",
               image = R.drawable.image2
           ))*/
           val cityId=it.arguments?.getInt("cityId").toString()
           MapScreen(cityId =cityId.toInt() )
       }
       composable(
           route = Screen.StartAlgorithm.route+"/{cityId}",
           arguments = listOf(navArgument("cityId"){
               type=NavType.IntType
           })
       ){
           val cityId=it.arguments?.getInt("cityId").toString()
           StartAlgorithmScreen(cityId = cityId.toInt())

       }


   }}

