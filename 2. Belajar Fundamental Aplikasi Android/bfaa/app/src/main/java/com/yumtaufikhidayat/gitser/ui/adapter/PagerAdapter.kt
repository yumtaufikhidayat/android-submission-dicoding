package com.yumtaufikhidayat.gitser.ui.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yumtaufikhidayat.gitser.ui.fragment.FollowerFragment
import com.yumtaufikhidayat.gitser.ui.fragment.FollowingFragment
import com.yumtaufikhidayat.gitser.ui.fragment.RepositoryFragment

class PagerAdapter(activity: AppCompatActivity, bundle: Bundle) : FragmentStateAdapter(activity) {

    private var bundleData: Bundle = bundle

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FollowingFragment()
            1 -> fragment = FollowerFragment()
            2 -> fragment = RepositoryFragment()
        }
        fragment?.arguments = this.bundleData
        return fragment as Fragment
    }
}