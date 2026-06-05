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
        rating = 3
    ),
    PortfolioItem(
        id = 2,
        title = "Fakultas Ekonomi dan Bisnis",
        shortDescription = "FEB",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/feb.png",
        secondaryMediaUrl = "file:///android_asset/feb_fotbar.png",
        rating = 5
    ),
    PortfolioItem(
        id = 3,
        title = "Fakultas Hukum",
        shortDescription = "FH",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/FH.png",
        secondaryMediaUrl = "file:///android_asset/fh_fotbar.png",
        rating = 4
    ),
    PortfolioItem(
        id = 4,
        title = "Fakultas Ilmu Sosial dan Ilmu Politik",
        shortDescription = "FISIP",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/fisip.png",
        secondaryMediaUrl = "file:///android_asset/fisip_fotbar.png",
        rating = 4
    ),
    PortfolioItem(
        id = 5,
        title = "Politeknik Banjarmasin",
        shortDescription = "Poliban",
        fullDescription = "placeholder",
        mainMediaUrl = "file:///android_asset/poliban.png",
        secondaryMediaUrl = "file:///android_asset/poliban_fotbar.png",
        rating = 3
    ),
)