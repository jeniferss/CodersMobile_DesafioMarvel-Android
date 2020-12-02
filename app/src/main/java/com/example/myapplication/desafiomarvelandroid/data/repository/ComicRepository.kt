package com.example.myapplication.desafiomarvelandroid.data.repository

class ComicRepository {
    private val _client = IComicEndpoint.Endpoint
    suspend fun obterComics(offset: Int? = 0) = _client.obterComics(offset)
}