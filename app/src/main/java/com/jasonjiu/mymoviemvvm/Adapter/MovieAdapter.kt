package com.jasonjiu.mymoviemvvm.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.jasonjiu.mymoviemvvm.models.Movie
import com.jasonjiu.mymoviemvvm.Views.DetailMovieActivity
import com.jasonjiu.mymoviemvvm.databinding.CvMovieBinding

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
                val bundle = bundleOf("movie_details" to list[position])
                intent.putExtra("movie_details", bundle)
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



