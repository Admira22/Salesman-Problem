package com.example.projekat


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.projekat.model.City
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


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
           route = Screen.Map.route+"/{cityId}",
           arguments = listOf(navArgument("cityId"){
               type = NavType.IntType
           })
       ){
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
           StartAlgorithmScreen(cityId = cityId.toInt(),navController=navController)

       }
       composable(
           route = Screen.SeeRoute.route+"/{cityId}/{gradoviJson}",
           arguments = listOf(navArgument("cityId"){
               type=NavType.IntType
           })
       ){
           val cityId=it.arguments?.getInt("cityId").toString()
           val gradJson=it.arguments?.getString("gradoviJson")
           gradJson?.let {
               val moshi=Moshi.Builder()
                   .addLast(KotlinJsonAdapterFactory())
                   .build()
               val jsonAdapter: JsonAdapter<List<City>> = moshi.adapter<List<City>>(
                   Types.newParameterizedType(List::class.java, City::class.java)
               )
               val gradJson=jsonAdapter.fromJson(gradJson)
           }
           SeeRouteScreen(cityId = cityId.toInt(), gradoviJson = gradJson.toString())

       }
   }}

