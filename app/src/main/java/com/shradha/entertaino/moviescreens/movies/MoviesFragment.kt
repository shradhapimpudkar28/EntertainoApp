package com.shradha.entertaino.moviescreens.movies

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shradha.entertaino.R
import com.shradha.entertaino.data.response.MovieItem
import com.shradha.entertaino.ui.home.MainActivity
import com.shradha.entertaino.utils.ApiException
import com.shradha.entertaino.utils.NoInternetException
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movies_fragment.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class MoviesFragment : Fragment(),
    RecyclerViewClickListener, KodeinAware {
    override val kodein: Kodein by kodein()
    private val factory: MoviesViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.movies_fragment, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        (activity as MainActivity)!!.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val viewModel = ViewModelProvider(this, factory).get(MoviesViewModel::class.java)


        try {
            viewModel.getMoviesListFromRepository()

        } catch (e: ApiException) {

        } catch (noInternet: NoInternetException) {

        }

        progress_bar.visibility = View.VISIBLE
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter =
                    MoviesAdapter(
                        movies,
                        this
                    )
                progress_bar.visibility = View.INVISIBLE

            }
        })

    }

    override fun onRecyclerViewItemClick(view: View, movieItem: MovieItem) {

        when (view.id) {

            R.id.button_book ->
                Toast.makeText(requireContext(), "Movie Booked", Toast.LENGTH_SHORT).show()

            R.id.imageViewLike ->
                Toast.makeText(requireContext(), "Like Clicked", Toast.LENGTH_SHORT).show()

        }

    }

}
