// DashboardScreen.kt
package com.example.kel1wawancara.screen

import android.media.MediaPlayer
import android.media.SoundPool
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kel1wawancara.R
import com.example.kel1wawancara.model.portfolioData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(onItemClick: (Int) -> Unit) {
    val context = LocalContext.current

    val mediaPlayer = remember {
        try { MediaPlayer.create(context, R.raw.bg_music) } catch (e: Exception) { null }
    }
    var isPlayingBgm by remember { mutableStateOf(false) }

    val soundPool = remember { SoundPool.Builder().setMaxStreams(5).build() }
    var soundId by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        try { soundId = soundPool.load(context, R.raw.star_ding, 1) } catch (e: Exception) {}
    }

    DisposableEffect(Unit) {
        onDispose {
            try {
                if (mediaPlayer?.isPlaying == true) mediaPlayer.stop()
                mediaPlayer?.release()
                soundPool.release()
            } catch (e: Exception) {}
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.background,
                            MaterialTheme.colorScheme.surface
                        )
                    )
                )
        )


        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = {
                                if (mediaPlayer == null) return@IconButton
                                try {
                                    if (isPlayingBgm) mediaPlayer.pause() else mediaPlayer.start()
                                    isPlayingBgm = !isPlayingBgm
                                } catch (e: Exception) {}
                            }) {
                                Icon(Icons.Default.PlayArrow, contentDescription = "BGM", tint = MaterialTheme.colorScheme.onPrimary)
                            }
                            Text(
                                text = if (mediaPlayer == null) "Audio Missing" else if (isPlayingBgm) "Playing: BGM" else "Music Paused",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(start = 8.dp),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item { Spacer(modifier = Modifier.height(8.dp)) }

                items(portfolioData) { item ->
                    PortfolioCard(
                        item = item,
                        onClick = { onItemClick(item.id) },
                        onRate = {
                            if (soundId != 0) {
                                try { soundPool.play(soundId, 1f, 1f, 0, 0, 1f) } catch (e: Exception) {}
                            }
                        }
                    )
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioCard(
    item: com.example.kel1wawancara.model.PortfolioItem,
    onClick: () -> Unit,
    onRate: () -> Unit
) {
    var currentRating by remember { mutableIntStateOf(item.rating) }

    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column {

            AsyncImage(
                model = item.mainMediaUrl,
                contentDescription = "Primary Local Media",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = item.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.shortDescription, style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(12.dp))

                AsyncImage(
                    model = item.secondaryMediaUrl,
                    contentDescription = "Secondary Local Media",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Rate: ", style = MaterialTheme.typography.labelLarge)
                    for (i in 1..5) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star $i",
                            tint = if (i <= currentRating) Color(0xFFD4AF37) else Color.LightGray,
                            modifier = Modifier
                                .size(32.dp)
                                .padding(horizontal = 2.dp)
                                .clickable {
                                    currentRating = i
                                    item.rating = i
                                    onRate()
                                }
                        )
                    }
                }
            }
        }
    }
}