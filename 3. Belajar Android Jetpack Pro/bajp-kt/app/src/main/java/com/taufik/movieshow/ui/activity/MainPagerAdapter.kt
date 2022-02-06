package com.taufik.movieshow.ui.activity

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.taufik.movieshow.R
import com.taufik.movieshow.ui.movie.fragment.FavoriteMovieFragment
import com.taufik.movieshow.ui.tvshow.fragment.FavoriteTvShowFragment

class MainPagerAdapter(private val context: Context, fragmentManager: FragmentManager)
    : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    @StringRes
    private val tabsTitle = intArrayOf(R.string.tvMovies, R.string.tvShows)

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteMovieFragment()
            1 -> fragment = FavoriteTvShowFragment()
        }

        return fragment as Fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(tabsTitle[position])
    }
}