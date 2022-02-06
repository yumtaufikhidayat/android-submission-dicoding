package com.taufik.movieshow.ui.movie.fragment

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
import com.taufik.movieshow.databinding.FragmentFavoriteMovieBinding
import com.taufik.movieshow.ui.activity.ViewModelFactory
import com.taufik.movieshow.ui.movie.adapter.FavoriteMovieAdapter
import com.taufik.movieshow.ui.movie.viewmodel.FavoriteMovieViewModel

class FavoriteMovieFragment : Fragment() {

    private var _binding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _binding
    private lateinit var movieViewModel: FavoriteMovieViewModel
    private lateinit var favoriteAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setData()
    }

    private fun setData() {
        binding?.apply {
            itemTouchHelper.attachToRecyclerView(rvFavoriteMovie)
            if (activity != null) {
                val factory = ViewModelFactory.getInstance(requireActivity())
                movieViewModel = ViewModelProvider(
                    this@FavoriteMovieFragment,
                    factory
                )[FavoriteMovieViewModel::class.java]
                favoriteAdapter = FavoriteMovieAdapter()

                progressBar.visibility = View.VISIBLE
                movieViewModel.getFavoriteMovies().observe(viewLifecycleOwner, {
                    progressBar.visibility = View.GONE
                    favoriteAdapter.submitList(it)
                })

                with(rvFavoriteMovie) {
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
                val movieEntity = favoriteAdapter.getSwipedData(swipedPosition)
                movieEntity?.let { movieViewModel.setFavorite(it) }
                val snackBar = Snackbar.make(view as View, R.string.tvCancelDelete, Snackbar.LENGTH_LONG).apply {
                    setAction(R.string.tvYes) { _ ->
                        movieEntity?.let { movieViewModel.setFavorite(it) }
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