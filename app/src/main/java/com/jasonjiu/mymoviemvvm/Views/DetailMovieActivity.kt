package com.jasonjiu.mymoviemvvm.Views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jasonjiu.mymoviemvvm.R
import com.jasonjiu.mymoviemvvm.Viewmodels.FavoriteMovieViewModel
import com.jasonjiu.mymoviemvvm.databinding.DetailMovieActivityBinding
import com.jasonjiu.mymoviemvvm.models.Movie

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val BUNDLE_DETAIL = "movie_details"
    }

    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var binding: DetailMovieActivityBinding
    private var isFav: Boolean? = null
    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.detail_movie_activity)
        viewModel = ViewModelProvider(this).get(FavoriteMovieViewModel::class.java)
        val bundle = intent.getBundleExtra(BUNDLE_DETAIL)
        movie = bundle.getParcelable<Movie>(BUNDLE_DETAIL)
        binding.detailMovie = movie

        viewModel.getSingleMovie(movie?.movieId).observe(this, Observer {
            isFav = it != null
        })

        binding.addFavorite.setOnClickListener {
            if (isFav!!) {
                viewModel.deleteMovie(movie)
                Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insertMovie(movie)
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
            }
        }
    }

}