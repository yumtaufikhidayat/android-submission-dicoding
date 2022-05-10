package com.yumtaufikhidayat.gitser.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.data.viewmodel.detail.DetailViewModel
import com.yumtaufikhidayat.gitser.databinding.FragmentRepositoryBinding
import com.yumtaufikhidayat.gitser.ui.activity.DetailActivity
import com.yumtaufikhidayat.gitser.ui.adapter.RepositoryAdapter

class RepositoryFragment : Fragment() {

    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding!!

    private val detailViewModel: DetailViewModel by viewModels()
    private lateinit var repositoryAdapter: RepositoryAdapter
    private lateinit var username: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArgument()
        initView()
        showRepositoryData()
    }

    private fun getArgument() {
        username = arguments?.getString(DetailActivity.EXTRA_PARCELABLE).toString()
    }

    private fun initView() {
        repositoryAdapter = RepositoryAdapter()
        binding.apply {
            with(rvRepos) {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = repositoryAdapter
            }
        }
    }

    private fun showRepositoryData() {
        showLoading(true)
        detailViewModel.apply {
            setListOfRepositories(username)
            getListOfRepositories().observe(viewLifecycleOwner) {
                if (it != null) {
                    if (it.size != 0) {
                        repositoryAdapter.submitList(it)
                        showNoData(false)
                    } else {
                        showNoData(true)
                    }
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(isShow: Boolean) = with(binding){
        if (isShow) {
            shimmerLoading.visibility = View.VISIBLE
            rvRepos.visibility = View.GONE
        } else {
            shimmerLoading.visibility = View.GONE
            rvRepos.visibility = View.VISIBLE
        }
    }

    private fun showNoData(isShow: Boolean) = with(binding) {
        viewNoRepositoryVisibility.visibility = if (isShow) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}