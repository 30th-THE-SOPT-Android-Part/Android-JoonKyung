package com.lee989898.soptlee.ui.repository

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.FragmentRepositoryBinding
import com.lee989898.soptlee.ui.repository.adapter.RepositoryAdapter
import com.lee989898.soptlee.ui.repository.viewmodel.RepositoryViewModel
import com.lee989898.soptlee.util.binding.BindingFragment

class RepositoryFragment :
    BindingFragment<FragmentRepositoryBinding>(R.layout.fragment_repository) {

    private lateinit var repositoryAdapter: RepositoryAdapter
    private val repositoryViewModel by viewModels<RepositoryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeRepositoryData()
        initRepositoryAdapter()
        repositoryViewModel.getRepositoryData()
    }

    private fun observeRepositoryData() {
        repositoryViewModel.repositoryData.observe(viewLifecycleOwner) {
            repositoryAdapter.data = it
        }
    }

    private fun initRepositoryAdapter() {
        repositoryAdapter = RepositoryAdapter()
        binding.repositoryListRv.adapter = repositoryAdapter
    }
}