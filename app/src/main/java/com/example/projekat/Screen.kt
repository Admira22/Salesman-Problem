package com.example.projekat

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Menu: Screen(route = "menu_screen")
    object Detail: Screen(route = "detail_screen")
    object List: Screen(route = "list_screen")
    object CityDetails: Screen(route = "city_screen")
    object Map: Screen(route = "map_screen")
    object StartAlgorithm: Screen(route = "algorithm_screen")
}
