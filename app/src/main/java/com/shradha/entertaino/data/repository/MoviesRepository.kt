package com.shradha.entertaino.data.repository

import com.shradha.entertaino.data.network.MoviesApi
import com.shradha.entertaino.data.network.SafeApiRequest

class MoviesRepository(private val api: MoviesApi) : SafeApiRequest() {

    suspend fun getMovies() = makeApiRequest {
        api.getMoviesList()
    }

}