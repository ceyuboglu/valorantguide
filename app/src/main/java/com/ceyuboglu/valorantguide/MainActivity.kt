package com.ceyuboglu.valorantguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ceyuboglu.valorantguide.presentation.navigation.AppNavHost
import com.ceyuboglu.valorantguide.ui.theme.ValorantGuideTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantGuideTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF141E29)
                ) {
                    AppNavHost()
                }
            }
        }
    }
}
