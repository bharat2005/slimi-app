package com.bharat.slimi.auth_feature.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bharat.slimi.app_root.AppRoutes
import com.bharat.slimi.auth_feature.presentation.register.RegisterScreen
import com.bharat.slimi.auth_feature.presentation.start.StartScreen

fun NavGraphBuilder.authNavGraph(navController : NavController){
    navigation(
        startDestination = AuthFeatureRoutes.Start,
        route = AppRoutes.AuthRoute
    ){

        //Start Composable
        composable(AuthFeatureRoutes.Start) {
            StartScreen(
                onRegisterClick = {navController.navigate(AuthFeatureRoutes.Register)}
            )
        }


        //Register Composable
        composable(AuthFeatureRoutes.Register) {
            RegisterScreen(
                onExit = {navController.navigateUp()},
                onRegisterSuccess = {}
            )
        }

    }
}