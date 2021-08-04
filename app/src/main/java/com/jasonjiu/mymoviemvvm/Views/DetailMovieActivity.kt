package com.jasonjiu.mymoviemvvm.Views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.jasonjiu.mymoviemvvm.Utils.Constant
import com.jasonjiu.mymoviemvvm.databinding.DetailMovieActivityBinding

class DetailMovieActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_POPULARITY = "extra_popularity"
        const val EXTRA_RELEASE = "extra_release"
        const val EXTRA_RATING = "extra_rating"
        const val EXTRA_BANNER = "extra_banner"
        const val EXTRA_OVERVIEW ="extra_overview"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailMovieActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getDetailTitle = intent.getStringExtra(EXTRA_TITLE)
        val getDetailPopularirty = intent.getStringExtra(EXTRA_POPULARITY)
        val getDetailRelease = intent.getStringExtra(EXTRA_RELEASE)
        val getDetailRating = intent.getStringExtra(EXTRA_RATING)
        val getDetailBanner = intent.getStringExtra(EXTRA_BANNER)
        val getDetailOverview = intent.getStringExtra(EXTRA_OVERVIEW)

        binding.tvFilmName.text = getDetailTitle
        binding.tvPopularity.text = getDetailPopularirty
        binding.tvReleaseDate.text = getDetailRelease
        binding.tvRating.text = getDetailRating
        binding.movieOverview.text = getDetailOverview
        Glide.with(this)
                .load(Constant.IMAGE_BASE_URL + Constant.IMAGE_W500 + getDetailBanner)
                .into(binding.ivFilmPhoto)
    }


}