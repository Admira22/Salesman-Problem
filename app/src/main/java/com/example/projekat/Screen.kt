package com.example.projekat

const val DETAIL_ARGUMENT_KEY = "id"
sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Menu: Screen(route = "menu_screen")
    object Detail: Screen(route = "detail_screen")
    object List: Screen(route = "list_screen")
    object CityDetails: Screen(route = "city_screen")
    object Route: Screen(route = "route_screen")
    object Map: Screen(route = "map_screen")
}
