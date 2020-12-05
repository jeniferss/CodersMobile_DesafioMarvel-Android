package com.example.myapplication.desafiomarvelandroid.home.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.desafiomarvelandroid.R
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel
import com.squareup.picasso.Picasso

class HomeViewHolder(private var view: View) : RecyclerView.ViewHolder(view) {

    private val _imgHome = view.findViewById<ImageView>(R.id.imgComicHome)
    private val _txtHome = view.findViewById<TextView>(R.id.txtComicHome)

    fun bind(comicModel: ComicModel) {

        _txtHome.text = comicModel.issueNumber.toString()

        Picasso.get()
            .load(comicModel.thumbnail.setarFullPath())
            .into(_imgHome)
    }
}