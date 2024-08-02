package com.jop.login_signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.jop.login_signup.ui.navigation.Navigation
import com.jop.login_signup.ui.theme.LoginSignupTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSignupTheme {
                val navController = rememberNavController()
                Navigation(navController = navController)
            }
        }
    }
}