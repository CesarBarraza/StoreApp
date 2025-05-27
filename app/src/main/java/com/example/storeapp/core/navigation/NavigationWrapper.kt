package com.example.storeapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.storeapp.ui.SplashScreen
import com.example.storeapp.ui.login.ui.LoginScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SplashScreen) {
        composable<SplashScreen> {
            SplashScreen {
                navController.popBackStack()
                navController.navigate(Login)
            }
        }

        composable<Login> {
            LoginScreen()
        }
    }
}