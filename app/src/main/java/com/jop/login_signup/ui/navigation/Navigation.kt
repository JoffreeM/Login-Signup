package com.jop.login_signup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavController){
    NavHost(navController = navController as NavHostController,
        startDestination = Screens.LOGIN){

        composable(Screens.LOGIN){

        }
        composable(Screens.REGISTER){

        }
    }
}