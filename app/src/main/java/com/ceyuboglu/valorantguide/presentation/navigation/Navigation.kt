package com.ceyuboglu.valorantguide.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceyuboglu.valorantguide.presentation.ui.agentdetail.AgentDetailScreen
import com.ceyuboglu.valorantguide.presentation.ui.agents.AgentListScreen
import com.ceyuboglu.valorantguide.presentation.ui.home.HomeScreen


@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(500)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(500)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(500)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(500)
            )
        }
    ) {
        composable(AppScreen.Home.route) {
            HomeScreen(
                onNavigateToAgents = {
                    navController.navigate(AppScreen.Agents.route)
                }
            )
        }
        composable(AppScreen.Agents.route) {
            AgentListScreen(
                onNavigateToAgentDetail = { agentId ->
                    navController.navigate(AppScreen.AgentDetail.createRoute(agentId))
                },
                onTapBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = AppScreen.AgentDetail.route
        ) { backStackEntry ->
            val agentId = backStackEntry.arguments?.getString("agentId")
            AgentDetailScreen(agentId = agentId)
        }
    }
}



sealed class AppScreen(val route: String) {
    data object Home : AppScreen("home")
    data object Agents : AppScreen("agents")
    data object AgentDetail : AppScreen("agent_detail/{agentId}") {
        fun createRoute(agentId: String) = "agent_detail/$agentId"
    }
}