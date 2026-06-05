// SplashScreen.kt
package com.example.kel1wawancara.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import com.example.kel1wawancara.R

@Composable
fun SplashScreen(onNavigateToDashboard: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(2000L)
        onNavigateToDashboard()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.campus_logo),
            contentDescription = "Campus Logo",
            modifier = Modifier.size(180.dp),
            contentScale = ContentScale.Fit
        )
    }
}