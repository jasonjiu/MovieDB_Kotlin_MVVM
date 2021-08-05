package com.jasonjiu.mymoviemvvm.Views.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jasonjiu.mymoviemvvm.Adapter.MovieAdapter
import com.jasonjiu.mymoviemvvm.Viewmodels.PopularMovieViewModel
import com.jasonjiu.mymoviemvvm.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment: Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var viewModel: PopularMovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(PopularMovieViewModel::class.java)
        viewModel.getPopularMovies()

        viewModel.popularMovie.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvListMovie.visibility = View.VISIBLE
                rvListMovie.layoutManager = LinearLayoutManager(context)
                rvListMovie.adapter = MovieAdapter(it)
            }
        })
    }


}