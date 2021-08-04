package com.jasonjiu.mymoviemvvm.Adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.sax.ElementListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jasonjiu.mymoviemvvm.models.Movie
import com.jasonjiu.mymoviemvvm.R
import com.jasonjiu.mymoviemvvm.Views.DetailMovieActivity
import com.jasonjiu.mymoviemvvm.Views.Fragment.HomeFragment
import com.jasonjiu.mymoviemvvm.Views.MainActivity
import com.jasonjiu.mymoviemvvm.databinding.ContentMovieSubviewBinding
import com.jasonjiu.mymoviemvvm.databinding.CvMovieBinding
import java.io.Serializable

class MovieAdapter(val list: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val binding = CvMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return MovieViewHolder(binding)
        }

        override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
            val movie: Movie = list[position]
            holder.bindData(movie)


            holder.itemView.setOnClickListener { v ->
                val intent = Intent(v.context, DetailMovieActivity::class.java)

                intent.putExtra( "extra_title", movie.original_title)
                intent.putExtra("extra_popularity", movie.popularity.toString())
                intent.putExtra("extra_release", movie.release_date)
                intent.putExtra("extra_rating", movie.vote_average.toString())
                intent.putExtra("extra_banner", movie.poster_path)
                intent.putExtra("extra_overview", movie.overview)
                v.context.startActivity(intent)
            }
        }

        override fun getItemCount(): Int {
           return list.size
        }

    inner class MovieViewHolder(val binding: CvMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(movie: Movie) {
            binding.movie = movie
        }
    }
 }



