package com.example.myapplication.desafiomarvelandroid.data.model

data class ComicModel(
    val id: Int,
    val issueNumber: Double,
    val title: String,
    val description: String,
    val thumbnail: ComicImageModel,
    val dates: List<ComicDateModel>,
    val pageCount : Int,
    val images: List<ComicImageModel>,
    val prices: List<ComicPriceModel>
)