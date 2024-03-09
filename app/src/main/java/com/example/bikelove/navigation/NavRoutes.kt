package com.example.bikelove.navigation

sealed class NavRoutes(val route: String) {
    object Authorization : NavRoutes("authorization")
    object ItemList : NavRoutes("itemList")
}