package com.taufik.movieshow.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.taufik.movieshow.R
import com.taufik.movieshow.databinding.ActivityMainBinding
import com.taufik.movieshow.ui.fragment.FavoriteFragment
import com.taufik.movieshow.ui.movie.fragment.MovieFragment
import com.taufik.movieshow.ui.tvshow.fragment.TvShowFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initActionBar()

        setFragment()
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            elevation = 0F
        }
    }

    private fun setFragment() {

        val movieFragment = MovieFragment()
        val tvShowFragment = TvShowFragment()
        val favoriteFragment = FavoriteFragment()

        setCurrentFragment(movieFragment)

        binding.apply {
            bottomNavigation.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_movie -> setCurrentFragment(movieFragment)
                    R.id.nav_tv_show -> setCurrentFragment(tvShowFragment)
                    R.id.nav_favorite -> setCurrentFragment(favoriteFragment)
                }
                true
            }
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
}