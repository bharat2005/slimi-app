package com.bharat.slimi.feature_auth.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bharat.slimi.core.navigation.ScreenRoutes
import com.bharat.slimi.feature_auth.presentation.login.LoginScreen
import com.bharat.slimi.feature_auth.presentation.register.RegisterScreen
import com.bharat.slimi.feature_auth.presentation.start.StartScreen

fun NavGraphBuilder.auhtNavGraph(navController: NavController){
    navigation(
        startDestination = AuthScreenRoutes.Start,
        route = ScreenRoutes.Auth
    ){
        composable(AuthScreenRoutes.Start) {
            StartScreen(
                onLoginClick = {navController.navigate(AuthScreenRoutes.Login)},
                onRegisterClick = {navController.navigate(AuthScreenRoutes.Register)}
            )
        }

        composable(AuthScreenRoutes.Register) {
            LoginScreen(

            )

        }

        composable(AuthScreenRoutes.Login) {
            RegisterScreen(

            )

        }

    }
}