package com.example.myapplication.desafiomarvelandroid.data.api
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel

data class DataModel<T> (
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<ComicModel>
)