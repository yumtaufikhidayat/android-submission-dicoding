package com.yumtaufikhidayat.gitser.ui.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: AppCompatActivity, bundle: Bundle) : FragmentStateAdapter(activity) {

    private var bundleData: Bundle = bundle

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {

        }
        fragment?.arguments = this.bundleData
        return fragment as Fragment
    }
}