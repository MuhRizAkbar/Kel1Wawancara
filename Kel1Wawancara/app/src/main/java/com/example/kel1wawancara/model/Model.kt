// Model.kt
package com.example.kel1wawancara.model

data class PortfolioItem(
    val id: Int,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val mainMediaUrl: String,
    val secondaryMediaUrl: String,
    var rating: Int = 0
)

val portfolioData = listOf(
    PortfolioItem(
        id = 1,
        title = "Fakultas Keguruan Ilmu Pendidikan",
        shortDescription = "FKIP",
        fullDescription = "A mobile productivity application designed for task management and focus tracking, helping users stay on top of their daily goals.",
        mainMediaUrl = "file:///android_asset/fkip.png",
        secondaryMediaUrl = "file:///android_asset/fkip_fotbar.png",
        rating = 4
    ),
    PortfolioItem(
        id = 2,
        title = "FEB",
        shortDescription = "placeholder",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/feb.png",
        secondaryMediaUrl = "file:///android_asset/"
    ),
    PortfolioItem(
        id = 3,
        title = "FH",
        shortDescription = "placeholder",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/FH.png",
        secondaryMediaUrl = "file:///android_asset/"
    ),
    PortfolioItem(
        id = 4,
        title = "FISIP",
        shortDescription = "placeholder",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/fisip.png",
        secondaryMediaUrl = "file:///android_asset/fisip_fotbar.png"
    ),
    PortfolioItem(
        id = 5,
        title = "Poliban",
        shortDescription = "placeholder",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/poliban.png",
        secondaryMediaUrl = "file:///android_asset/"
    ),
)