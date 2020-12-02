package com.example.myapplication.desafiomarvelandroid.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ComicDateModel (
    @SerializedName("date")
    val date: Date?
)