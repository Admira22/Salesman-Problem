package com.example.projekat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.projekat.repository.CityRepository

@Composable
fun ListScreen(navController: NavController) {
    val cityRepository = CityRepository()
    val getAllData = cityRepository.getAllData()
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
       verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = getAllData){
            CustomItem(city = it, navController = navController)
            //rememberNavController()
        }
    }
}
