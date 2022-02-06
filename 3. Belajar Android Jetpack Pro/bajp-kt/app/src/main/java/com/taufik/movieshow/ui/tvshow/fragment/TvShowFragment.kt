package com.taufik.movieshow.ui.tvshow.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.movieshow.databinding.FragmentTvShowBinding
import com.taufik.movieshow.ui.activity.ViewModelFactory
import com.taufik.movieshow.ui.tvshow.adapter.TvShowAdapter
import com.taufik.movieshow.ui.tvshow.viewmodel.TvShowViewModel
import com.taufik.movieshow.vo.Status

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding

    private lateinit var viewModel: TvShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
    }

    private fun setData() {

        binding?.apply {

            if (activity != null) {

                val factory = ViewModelFactory.getInstance(requireActivity())
                viewModel = ViewModelProvider(
                    requireActivity(),
                    factory
                )[TvShowViewModel::class.java]
                tvShowAdapter = TvShowAdapter()
            }

            viewModel.getTvShows().observe(viewLifecycleOwner, {
                Log.e(TAG, "setData: $it")
                if (it != null) {
                    when (it.status) {
                        Status.LOADING -> {
                            progressBar.visibility = View.VISIBLE
                        }

                        Status.SUCCESS -> {
                            progressBar.visibility = View.GONE
                            Log.e(TAG, "setData: ${it.data}")
                            tvShowAdapter.submitList(it.data)
                        }

                        Status.ERROR -> {
                            progressBar.visibility = View.GONE
                            Toast.makeText(requireActivity(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "TV_SHOW_FRAGMENT"
    }
}