package com.redevrx.composetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.redevrx.composetutorial.navigation.Nav
import com.redevrx.composetutorial.navigation.NavigationGraph
import com.redevrx.composetutorial.ui.theme.ComposeTutorialTheme
import com.redevrx.jacketshop.navigation.JacketDestination


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                NavigationGraph()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(nav:NavHostController = Nav.current) {
    Column() {
            Greeting("Android")
            Button(onClick = { nav.navigate("${JacketDestination.JACKET_SCREEN.router}") }) {
                Text(text = "Click")
            }
        }
}