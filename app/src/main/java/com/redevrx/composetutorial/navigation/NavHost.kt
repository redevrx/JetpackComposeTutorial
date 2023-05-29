package com.redevrx.composetutorial.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.redevrx.composetutorial.GreetingPreview
import com.redevrx.ui.navigation.shopScreen

val Nav = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

fun NavController.navigateTo(destination: String){
    kotlin.runCatching {
        navigate(destination)
    }.onFailure {
        Log.e("navigation error","not found destination -> error $it")
    }
}

@Composable
fun NavigationGraph(){
    NavHost(navController = Nav.current, startDestination = HomeDestination.HOME_SCREEN.router, modifier = Modifier){
        composable(route = HomeDestination.HOME_SCREEN.router){
            GreetingPreview()
        }
        shopScreen()
    }
}