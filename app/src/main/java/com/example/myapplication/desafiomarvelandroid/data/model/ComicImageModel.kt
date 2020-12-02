package com.example.myapplication.desafiomarvelandroid.data.model

data class ComicImageModel(
    var path: String,
    var extension: String,
){
    fun setarFullPath(): String{
        return path+"/portrait_small."+extension.replace("http://", "https://")
    }
}

