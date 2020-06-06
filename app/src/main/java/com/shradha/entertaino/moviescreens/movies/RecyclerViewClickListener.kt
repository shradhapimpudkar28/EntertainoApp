package com.shradha.entertaino.moviescreens.movies

import android.view.View
import com.shradha.entertaino.data.response.MovieItem

interface RecyclerViewClickListener {

    fun onRecyclerViewItemClick(view: View, movieItem: MovieItem)
}