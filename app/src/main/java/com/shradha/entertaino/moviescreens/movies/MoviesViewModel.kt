package com.shradha.entertaino.moviescreens.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shradha.entertaino.data.repository.MoviesRepository
import com.shradha.entertaino.data.response.MovieItem
import com.shradha.entertaino.utils.Coroutines
import kotlinx.coroutines.Job

class MoviesViewModel(private val repository: MoviesRepository) : ViewModel() {


    private val _movies by lazy {
        MutableLiveData<List<MovieItem>>()
    }

    // fun getMovies(): LiveData<List<MovieItem>> = movies_

    val movies: LiveData<List<MovieItem>> get() = _movies

    private lateinit var job: Job
    fun getMoviesListFromRepository(){


        job = Coroutines.ioToMainThread(
            {
                repository.getMovies()
            },
            {
                _movies.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}
