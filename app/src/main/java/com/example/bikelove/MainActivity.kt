package com.example.bikelove

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bikelove.navigation.NavRoutes
import com.example.bikelove.ui.authorization.AuthorizationScreen
import com.example.bikelove.theme.MainTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                InitializeNavHost()
            }
        }
    }

    @Composable
    fun InitializeNavHost() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = NavRoutes.Authorization.route) {
            composable(NavRoutes.Authorization.route) {
                AuthorizationScreen(navController)
            }
        }
    }
}