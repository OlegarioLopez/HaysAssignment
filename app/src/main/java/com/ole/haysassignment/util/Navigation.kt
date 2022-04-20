package com.ole.haysassignment.util

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ole.haysassignment.presentation.DetailListScreen
import com.ole.haysassignment.presentation.ListScreen
import com.ole.haysassignment.presentation.MapGoogle
import com.ole.haysassignment.presentation.mainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun Navigation() {
    val viewModel: mainViewModel = hiltViewModel()
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.ListScreen.route
    ) {
        composable(route = ScreenRoutes.ListScreen.route) {
            ListScreen(
                viewModel,
                navController = navController
            )
        }
        composable(route = ScreenRoutes.DetailListScreen.route) {
            DetailListScreen(
                viewModel,
                navController = navController
            )
        }
        composable(route = ScreenRoutes.MapScreen.route) {
            MapGoogle(
                viewModel,
                navController = navController
            )
        }

    }
}