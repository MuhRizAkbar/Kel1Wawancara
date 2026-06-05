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
        fullDescription = "Secara keseluruhan, kebersihan lingkungan kampus terawat dengan baik dan kantin yang tersedia cukup nyaman. Sayangnya, kenyamanan kegiatan belajar mengajar sedikit terganggu akibat kendala fasilitas, terutama pada ruang kelas di lantai bawah di mana banyak unit AC yang tidak berfungsi.",
        mainMediaUrl = "file:///android_asset/fkip.png",
        secondaryMediaUrl = "file:///android_asset/fkip_fotbar.png",
        rating = 3
    ),
    PortfolioItem(
        id = 2,
        title = "Fakultas Ekonomi dan Bisnis",
        shortDescription = "FEB",
        fullDescription = "Kebersihan area ini sangat terjaga dan sudah dilengkapi kipas angin, meski kapasitas tempat duduk masih belum sebanding dengan banyaknya jumlah mahasiswa. Mengingat lokasinya yang didirikan di atas lahan rawa, terkadang masih tercium aroma kurang sedap, meskipun manajemen pengelolaan sampah kampus sebenarnya sudah berjalan dengan sangat baik.",
        mainMediaUrl = "file:///android_asset/feb.png",
        secondaryMediaUrl = "file:///android_asset/feb_fotbar.png",
        rating = 5
    ),
    PortfolioItem(
        id = 3,
        title = "Fakultas Hukum",
        shortDescription = "FH",
        fullDescription = "Potret salah satu ruang kelas di Fakultas Hukum. Secara umum, fasilitas dasar seperti kursi, proyektor LCD, dan kipas angin sudah memadai dengan kapasitas ruang yang sangat cukup untuk menampung mahasiswa. Namun, kenyamanan belajar di beberapa kelas masih perlu ditingkatkan karena belum dilengkapi dengan AC",
        mainMediaUrl = "file:///android_asset/FH.png",
        secondaryMediaUrl = "file:///android_asset/fh_fotbar.png",
        rating = 4
    ),
    PortfolioItem(
        id = 4,
        title = "Fakultas Ilmu Sosial dan Ilmu Politik",
        shortDescription = "FISIP",
        fullDescription = "Kebersihan kampus terawat dengan baik dan ketersediaan ruang kelas sudah memadai. Meski akses internet masih lambat di beberapa titik dan fasilitas makan hanya ada sebuah koperasi. Pihak fakultas pin sangat responsif dan cepat dalam menanggapi aspirasi mahasiswa terkait perbaikan fasilitas.",
        mainMediaUrl = "file:///android_asset/fisip.png",
        secondaryMediaUrl = "file:///android_asset/fisip_fotbar.png",
        rating = 4
    ),
    PortfolioItem(
        id = 5,
        title = "Politeknik Banjarmasin",
        shortDescription = "Poliban",
        fullDescription = "Terdapat peningkatan fasilitas berupa kantin yang baru direnovasi menjadi lebih nyaman serta perluasan area parkir. Namun, kampus ini masih terdapat kekurangan pada fasilitas penunjang belajar; seperti hilangnya akses koneksi Wi-Fi di lantai satu, sejumlah bangku kelas yang mulai rusak, serta kurangnya ruang kelas yang terkadang membuat mahasiswa harus berebut ruangan.",
        mainMediaUrl = "file:///android_asset/poliban.png",
        secondaryMediaUrl = "file:///android_asset/poliban_fotbar.png",
        rating = 3
    ),
)