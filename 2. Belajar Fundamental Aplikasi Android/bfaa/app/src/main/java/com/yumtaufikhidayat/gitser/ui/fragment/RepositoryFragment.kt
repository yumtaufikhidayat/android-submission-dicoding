package com.yumtaufikhidayat.gitser.ui.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.gitser.R
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
        checkThemes()
        initView()
        initObserver()
    }

    private fun getArgument() {
        username = arguments?.getString(DetailActivity.EXTRA_PARCELABLE).toString()
    }

    private fun checkThemes() = with(binding) {
        when (requireContext().resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)) {
            Configuration.UI_MODE_NIGHT_YES -> {
                layoutNoRepository.tvNoRepositoryTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
                layoutNoRepository.tvNoRepositoryDesc.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            }

            Configuration.UI_MODE_NIGHT_NO -> {
                layoutNoRepository.tvNoRepositoryTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                layoutNoRepository.tvNoRepositoryDesc.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }

            Configuration.UI_MODE_NIGHT_UNDEFINED -> {
                layoutNoRepository.tvNoRepositoryTitle.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                layoutNoRepository.tvNoRepositoryDesc.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            }
        }
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

    private fun initObserver() {
        detailViewModel.apply {
            setListOfRepositories(username)
            listOfRepositoriesData.observe(viewLifecycleOwner) {
                if (it != null) {
                    if (it.size != 0) {
                        repositoryAdapter.submitList(it)
                        showNoData(false)
                    } else {
                        showNoData(true)
                    }
                }
            }

            isLoading.observe(viewLifecycleOwner) {
                showLoading(it)
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