package com.redevrx.ui.navigation

import androidx.compose.material3.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.redevrx.ui.screen.ShopScreen

fun NavGraphBuilder.shopScreen() {
    composable(
        route = ShopDestination.SHOP_SCREEN.router,
        arguments = listOf(),
    ) {
        ShopScreen()
    }
}