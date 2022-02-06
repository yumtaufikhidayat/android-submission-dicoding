package com.taufik.movieshow.ui.tvshow.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.taufik.movieshow.R
import com.taufik.movieshow.databinding.FragmentFavoriteTvshowBinding
import com.taufik.movieshow.ui.activity.ViewModelFactory
import com.taufik.movieshow.ui.tvshow.adapter.FavoriteTvShowAdapter
import com.taufik.movieshow.ui.tvshow.viewmodel.FavoriteTvShowViewModel

class FavoriteTvShowFragment : Fragment() {

    private var _binding: FragmentFavoriteTvshowBinding? = null
    private val binding get() = _binding
    private lateinit var tvShowViewModel: FavoriteTvShowViewModel
    private lateinit var favoriteAdapter: FavoriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteTvshowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
    }

    private fun setData() {
        binding?.apply {
            itemTouchHelper.attachToRecyclerView(rvFavoriteTvShow)
            if (activity != null) {
                val factory = ViewModelFactory.getInstance(requireActivity())
                tvShowViewModel = ViewModelProvider(
                    this@FavoriteTvShowFragment,
                    factory
                )[FavoriteTvShowViewModel::class.java]
                favoriteAdapter = FavoriteTvShowAdapter()

                progressBar.visibility = View.VISIBLE
                tvShowViewModel.getFavoriteTvShows().observe(viewLifecycleOwner, {
                    progressBar.visibility = View.GONE
                    favoriteAdapter.submitList(it)
                })

                with(rvFavoriteTvShow) {
                    layoutManager = LinearLayoutManager(requireActivity())
                    setHasFixedSize(true)
                    adapter = favoriteAdapter
                }
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback(){
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = favoriteAdapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { tvShowViewModel.setFavorite(it) }
                val snackBar = Snackbar.make(view as View, R.string.tvCancelDelete, Snackbar.LENGTH_LONG).apply {
                    setAction(R.string.tvYes) { _ ->
                        tvShowEntity?.let { tvShowViewModel.setFavorite(it) }
                    }
                }
                snackBar.show()
            }
        }
    })

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}