package com.example.myapplication.desafiomarvelandroid.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.desafiomarvelandroid.R
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel

class HomeAdapter(
    private var _comics: MutableList<ComicModel>,
    private val _listener: (ComicModel) -> Unit
) :
    RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.comic_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = _comics[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { _listener(item) }
    }

    override fun getItemCount() = _comics.size
}