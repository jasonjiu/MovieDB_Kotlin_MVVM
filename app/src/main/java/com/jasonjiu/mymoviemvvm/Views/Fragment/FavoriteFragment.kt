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
import com.jasonjiu.mymoviemvvm.Viewmodels.FavoriteMovieViewModel
import com.jasonjiu.mymoviemvvm.databinding.FavFragmentBinding
import kotlinx.android.synthetic.main.fav_fragment.*

class FavoriteFragment: Fragment() {
    private lateinit var binding: FavFragmentBinding
    private lateinit var viewModel: FavoriteMovieViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FavFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(FavoriteMovieViewModel::class.java)
        viewModel.getAllMovies().observe(viewLifecycleOwner, Observer {
            it?.let {
                rvListMovie.visibility = View.VISIBLE
                rvListMovie.layoutManager = LinearLayoutManager(context)
                rvListMovie.adapter = MovieAdapter(it)

            }
        })
    }

}