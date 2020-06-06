package com.shradha.entertaino.moviescreens.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shradha.entertaino.R
import com.shradha.entertaino.data.response.MovieItem
import com.shradha.entertaino.databinding.MovieItemBinding

class MoviesAdapter(
    private val movies: List<MovieItem>, private val listener: RecyclerViewClickListener
) :
    RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesHolder(
            DataBindingUtil.inflate
                (
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {

        holder.recyclerviewMovieBinding.movie = movies[position]
        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            listener.onRecyclerViewItemClick(
                holder.recyclerviewMovieBinding.buttonBook,
                movies[position]
            )

        }
        holder.recyclerviewMovieBinding.imageViewLike.setOnClickListener {
            listener.onRecyclerViewItemClick(
                holder.recyclerviewMovieBinding.imageViewLike,
                movies[position]
            )

        }
    }

    inner class MoviesHolder(val recyclerviewMovieBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(recyclerviewMovieBinding.root)
}