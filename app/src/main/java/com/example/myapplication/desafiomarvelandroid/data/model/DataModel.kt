package com.example.myapplication.desafiomarvelandroid.data.model
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel

data class DataModel<T> (
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<ComicModel>
)