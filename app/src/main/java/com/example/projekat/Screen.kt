package com.example.projekat

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Menu: Screen(route = "menu_screen")
    object Detail: Screen(route = "detail_screen")
    object List: Screen(route = "list_screen")
}
