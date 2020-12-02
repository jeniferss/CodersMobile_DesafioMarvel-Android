package com.example.myapplication.desafiomarvelandroid.data.model

data class ComicImageModel(
    var path: String,
    var extension: String,
) {
    fun setarFullPath(size: String? = "detail"): String {
        return "$path/$size.$extension".replace("http://", "https://")
    }
}

