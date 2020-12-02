package com.example.myapplication.desafiomarvelandroid.data.repository

import com.example.myapplication.desafiomarvelandroid.data.model.ResponseModel
import com.example.myapplication.desafiomarvelandroid.data.network.NetworkUtils
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel
import retrofit2.http.GET

interface IComicEndpoint {

    @GET("v1/public/characters/1009610/comics")
    suspend fun obterComics(): ResponseModel<ComicModel>

    companion object {
        val Endpoint: IComicEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(IComicEndpoint::class.java)
        }
    }
}