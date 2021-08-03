package com.jasonjiu.mymoviemvvm.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jasonjiu.mymoviemvvm.R
import com.jasonjiu.mymoviemvvm.Viewmodels.PopularMovieViewModel
import com.jasonjiu.mymoviemvvm.Views.Fragment.FavoriteFragment
import com.jasonjiu.mymoviemvvm.Views.Fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val homeFragment = HomeFragment()
    val favoriteFragment = FavoriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setCurrentFragment(homeFragment)
        navigationFragment()

    }

    private fun navigationFragment(){
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment->setCurrentFragment(homeFragment)
                R.id.favoriteFragment->setCurrentFragment(favoriteFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}