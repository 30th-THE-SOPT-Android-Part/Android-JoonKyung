package com.lee989898.soptlee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.lee989898.soptlee.databinding.FragmentRepositoryBinding


class RepositoryFragment : Fragment() {

    private lateinit var repositoryAdapter: RepositoryAdapter
    private var _binding: FragmentRepositoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryBinding.inflate(layoutInflater, container, false)
        initRepositoryAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRepositoryAdapter() {
        repositoryAdapter = RepositoryAdapter()
        binding.repositoryListRv.adapter = repositoryAdapter

        repositoryAdapter.repositoryList.addAll(
            listOf(
                RepositoryData(
                    "안드로이드 과제 레포지토리", "안드로이드 파트 과제안드로이드 파트 과제안드로이드 파트 과제안드로이드 파트 과제" +
                            "안드로이드 파트 과제안드로이드 파트 과제안드로이드 파트 과제안드로이드 파트 과제안드로이드 파트 과제안드로이드 파트 과제"
                ),
                RepositoryData("ios 과제 레포지토리", "ios 파트 과제"),
                RepositoryData("서버 과제 레포지토리", "서버 파트 과제"),
                RepositoryData("기획 과제 레포지토리", "기획 파트 과제"),
                RepositoryData("웹 과제 레포지토리", "웹 파트 과제"),
                RepositoryData("디자인 과제 레포지토리", "디자인 파트 과제")
            )
        )
        repositoryAdapter.notifyDataSetChanged()

    }


}