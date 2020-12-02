package com.example.myapplication.desafiomarvelandroid.home.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.desafiomarvelandroid.R
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.comic_item.view.*

class HomeViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {

    val imgHome = view.findViewById<ImageView>(R.id.imgComicHome)
    val txtHome = view.findViewById<TextView>(R.id.txtComicHome)

    fun bind(comicModel: ComicModel) {

        txtHome.text = comicModel.id.toString()

        Picasso.get()
            .load(comicModel.thumbnail.setarFullPath())
            .into(imgHome)
    }
}