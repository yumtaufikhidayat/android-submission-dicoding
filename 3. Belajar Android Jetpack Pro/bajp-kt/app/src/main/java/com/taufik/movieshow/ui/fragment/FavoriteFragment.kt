package com.taufik.movieshow.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.movieshow.databinding.FragmentFavoriteBinding
import com.taufik.movieshow.ui.activity.MainPagerAdapter

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()
    }

    private fun setViewPager() {
        val mainPagerAdapter = MainPagerAdapter(requireActivity(), childFragmentManager)
        binding?.apply {
            viewPagerFavorite.adapter = mainPagerAdapter
            tabLayoutFavorite.setupWithViewPager(viewPagerFavorite)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}