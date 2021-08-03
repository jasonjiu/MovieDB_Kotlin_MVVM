package com.jasonjiu.mymoviemvvm.Adapter

import android.content.Context
import android.sax.ElementListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jasonjiu.mymoviemvvm.models.Movie
import com.jasonjiu.mymoviemvvm.R
import com.jasonjiu.mymoviemvvm.databinding.CvMovieBinding

class MovieAdapter(val list: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = CvMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }


        override fun onBindViewHolder(holder: MovieAdapter.MovieViewHolder, position: Int) {
            val movie: Movie = list[position]
            holder.bindData(movie)

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



