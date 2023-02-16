package com.example.20230215-EsosaseheIgiehon-nycSchools.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.20230215-EsosaseheIgiehon-nycSchools.ui.screens.common.MainViewModel
import com.example.20230215-EsosaseheIgiehon-nycSchools.ui.screens.home.NYCSchoolsList
import com.example.20230215-EsosaseheIgiehon-nycSchools.ui.screens.details.Details

@Composable
fun Navigation(viewModel: MainViewModel = hiltViewModel()) {

    val navController = rememberNavController()

    val arguments = listOf(
        navArgument("dbn") { type = NavType.StringType }
    )

    NavHost(navController = navController, startDestination = "schoolsList") {
        composable("schoolsList") {
            NYCSchoolsList(
                selectedUser = { dbn ->
                    viewModel.getNYCSchoolDetails(dbn)
                    navController.navigate("schoolDetails/$dbn") }
            ) }
        composable("schoolDetails") {
            Details(
                onNavigateBack = {}
            ) }
        composable(
            route = "schoolDetails/{dbn}",
            arguments = arguments
        ) { navBackStackEntry ->
            val dbn =
                navBackStackEntry.arguments?.getString("dbn")
            if (dbn != null) {
                Details(
                    schoolId = dbn,
                    onNavigateBack = {navController.navigate("schoolsList")}
                )
            }
        }
    }
}

