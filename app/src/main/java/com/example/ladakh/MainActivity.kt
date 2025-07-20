package com.example.ladakh

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ladakh.DataSources.DataSources.HomeScreenItems
import com.example.ladakh.ui.theme.HomeScreenUi
import com.example.ladakh.ui.theme.LadakhApp
import com.example.ladakh.ui.theme.LadakhTheme
import com.example.ladakh.ui.theme.TopAppBar

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LadakhTheme {
                val windowSize =  calculateWindowSizeClass(this)
                LadakhApp(windowSize = windowSize.widthSizeClass)
            }
        }
    }
}





@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LadakhTheme {
        Scaffold {
         TopAppBar()
            HomeScreenUi(
                homescreenitems = HomeScreenItems,
                onCardClicked = {}
            )
    }
    }
}