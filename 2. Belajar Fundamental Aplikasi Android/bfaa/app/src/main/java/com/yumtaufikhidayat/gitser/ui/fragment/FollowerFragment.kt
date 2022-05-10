package com.yumtaufikhidayat.gitser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.R
import com.yumtaufikhidayat.gitser.data.viewmodel.detail.DetailViewModel
import com.yumtaufikhidayat.gitser.databinding.FragmentFollowsBinding
import com.yumtaufikhidayat.gitser.ui.activity.DetailActivity
import com.yumtaufikhidayat.gitser.ui.adapter.SearchAdapter

class FollowerFragment : Fragment() {

    private var _binding: FragmentFollowsBinding? = null
    private val binding get() = _binding!!

    private val detailViewModel: DetailViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter
    private lateinit var username: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFollowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArgument()
        initView()
        showFollowersData()
    }

    private fun getArgument() {
        username = arguments?.getString(DetailActivity.EXTRA_PARCELABLE).toString()
    }

    private fun initView() {
        searchAdapter = SearchAdapter()
        binding.apply {
            with(rvFollows) {
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = searchAdapter
            }
        }
    }

    private fun showFollowersData() {
        showLoading(true)
        detailViewModel.apply {
            setListOfFollower(username)
            getListOfFollower().observe(viewLifecycleOwner) {
                if (it != null) {
                    if (it.size != 0) {
                        searchAdapter.submitList(it)
                        showNoData(false)
                    } else {
                        showNoData(true)
                    }
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(isShow: Boolean) = with(binding) {
        if (isShow) {
            shimmerFollows.visibility = View.VISIBLE
            rvFollows.visibility = View.GONE
        } else {
            shimmerFollows.visibility = View.GONE
            rvFollows.visibility = View.VISIBLE
        }
    }

    private fun showNoData(isShow: Boolean) = with(binding) {
        if (isShow) {
            viewNoFollowsVisibility.visibility = View.VISIBLE
            layoutNoFollows.tvNoDataDesc.text = getString(R.string.tvNoFollowers)
        } else {
            viewNoFollowsVisibility.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}