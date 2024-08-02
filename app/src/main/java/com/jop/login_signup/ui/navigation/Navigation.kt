package com.jop.login_signup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jop.login_signup.ui.screens.authentication.login.LoginScreen
import com.jop.login_signup.ui.screens.authentication.register.RegisterScreen

@Composable
fun Navigation(navController: NavController){
    NavHost(navController = navController as NavHostController,
        startDestination = Screens.LOGIN){

        composable(Screens.LOGIN){
            LoginScreen(navController = navController)
        }
        composable(Screens.REGISTER){
            RegisterScreen(navController = navController)
        }
    }
}