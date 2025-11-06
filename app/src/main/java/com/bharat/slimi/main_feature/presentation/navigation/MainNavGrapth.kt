package com.bharat.slimi.main_feature.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.bharat.slimi.app_root.AppRoutes
import com.bharat.slimi.main_feature.presentation.home.HomeScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController){
    navigation(
        startDestination = MainFeatureRoutes.Home,
        route = AppRoutes.MainRoute
    ){
        composable(MainFeatureRoutes.Home){
            HomeScreen()
        }
    }
}