package com.bharat.slimi.app_root


import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bharat.slimi.auth_feature.presentation.navigation.AuthFeatureRoutes
import com.bharat.slimi.auth_feature.presentation.navigation.authNavGraph
import com.bharat.slimi.main_feature.presentation.navigation.mainNavGraph


@Composable
fun AppRoot(
    viewModel: AppRootViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val authState by viewModel.authState.collectAsStateWithLifecycle()

    val startDestination = when(authState){
        AuthState.UNKNOWN -> AppRoutes.SpalshRoute
        AuthState.UNAUTHENTICATED -> AppRoutes.AuthRoute
        AuthState.AUTHENTICATED -> AppRoutes.MainRoute

    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        NavHost(
            navController = navController,
            startDestination = startDestination
        ){

            //splash route
            composable(AppRoutes.SpalshRoute){
                Box(modifier = Modifier.fillMaxSize().background(Color.Transparent))
            }

            //auth route
            authNavGraph(navController)

            //main route
            mainNavGraph(navController)





        }
    }
}