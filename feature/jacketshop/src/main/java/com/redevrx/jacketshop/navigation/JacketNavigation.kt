package com.redevrx.jacketshop.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.redevrx.jacketshop.screen.JacketScreen


fun NavGraphBuilder.jacketScreen(){
    composable(
        route = JacketDestination.JACKET_SCREEN.router,
        arguments = listOf()
    ){
       JacketScreen()
    }
}