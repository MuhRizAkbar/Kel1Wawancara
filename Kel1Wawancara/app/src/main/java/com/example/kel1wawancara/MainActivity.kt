package com.example.kel1wawancara

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.kel1wawancara.nav.PortfolioApp
import com.example.kel1wawancara.ui.theme.Kel1WawancaraTheme // Import your new theme!

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This is the crucial change: using your custom theme!
            Kel1WawancaraTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background // This will now pull "Warm Cream"
                ) {
                    PortfolioApp()
                }
            }
        }
    }
}