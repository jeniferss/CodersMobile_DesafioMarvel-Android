package com.example.myapplication.desafiomarvelandroid.data.api

data class ResponseModel <T>(
    val code: Int?,
    val status: String?,
    val copyright: String?,
    val attributionText: String?,
    val attributionHTML: String?,
    val data: DataModel<T>,
    val etag: String?
)