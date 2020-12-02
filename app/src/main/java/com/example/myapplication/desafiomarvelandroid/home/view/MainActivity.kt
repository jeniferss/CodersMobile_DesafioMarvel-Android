package com.example.myapplication.desafiomarvelandroid.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.desafiomarvelandroid.R
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel
import com.example.myapplication.desafiomarvelandroid.data.repository.ComicRepository
import com.example.myapplication.desafiomarvelandroid.detail.view.DetailActivity
import com.example.myapplication.desafiomarvelandroid.home.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _viewModel: HomeViewModel
    private lateinit var _homeAdapter: HomeAdapter
    private var _listaComics = mutableListOf<ComicModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val comicRecycler = findViewById<RecyclerView>(R.id.listComic)
        val manager = GridLayoutManager(this, 3)

        _listaComics = mutableListOf()

        _homeAdapter = HomeAdapter(_listaComics) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("NOME", it.title)
            intent.putExtra("DESCRICAO", it.description)
            intent.putExtra("IMAGE", it.thumbnail.path+"/portrait_small."+it.thumbnail.extension)
            intent.putExtra("QTD_PAGINAS", it.pageCount)
            startActivity(intent)
        }

        comicRecycler.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _homeAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            HomeViewModel.HomeViewModelFactory(ComicRepository())
        ).get(HomeViewModel::class.java)

        _viewModel.obterComics().observe(this, {
            exibirResultados(it)
        })

        setScrollView()
    }

    private fun setScrollView() {
        findViewById<RecyclerView>(R.id.listComic).addOnScrollListener(object :
            RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val target = recyclerView.layoutManager as GridLayoutManager?

                val totalItemCount = target!!.itemCount

                val lastVisible = target.findLastVisibleItemPosition()

                val lastItem = lastVisible + 5 >= totalItemCount

                if (totalItemCount > 0 && lastItem) {
                    _viewModel.proximaPagina().observe(this@MainActivity, {
                        exibirResultados(it)
                    })
                }
            }
        })

    }

    private fun exibirResultados(lista: List<ComicModel>?) {
        lista?.let { _listaComics.addAll(it) }
        _homeAdapter.notifyDataSetChanged()
    }
}

