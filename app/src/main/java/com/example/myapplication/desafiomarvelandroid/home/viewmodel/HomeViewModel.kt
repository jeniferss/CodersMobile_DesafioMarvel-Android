package com.example.myapplication.desafiomarvelandroid.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.myapplication.desafiomarvelandroid.data.api.ResponseModel
import com.example.myapplication.desafiomarvelandroid.data.model.ComicModel
import com.example.myapplication.desafiomarvelandroid.data.repository.ComicRepository
import kotlinx.coroutines.Dispatchers

class HomeViewModel(private val _repository: ComicRepository) : ViewModel() {

    private var _page: Int = 0
    private var _total: Int = 0
    private var _count: Int = 0
    private var _comics: List<ComicModel> = listOf()

    fun obterComics() = liveData(Dispatchers.IO) {
        val response = _repository.obterComics()
       _count = response.data.count
        if(response.data.total > 0){
            _total = response.data.total / _count
        }
        _comics = response.data.results
        emit(response.data.results)
    }

    fun proximaPagina() = liveData(Dispatchers.IO) {
        if (_page + 1 <= _total) {
            _page++

            val response = _repository.obterComics(_page)
            emit(response.data.results)
        }
    }

    class HomeViewModelFactory(
        private val _repository: ComicRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(_repository) as T
        }
    }
}