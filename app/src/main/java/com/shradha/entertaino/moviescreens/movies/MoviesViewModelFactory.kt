package com.shradha.entertaino.moviescreens.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shradha.entertaino.data.repository.MoviesRepository

@Suppress("UNCHECKED_CAST")
class MoviesViewModelFactory(private val moviesRepository: MoviesRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return MoviesViewModel(
            moviesRepository
        ) as T
    }
}