package com.lee989898.soptlee.repository

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lee989898.soptlee.databinding.ItemRepositoryListBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.FollowerViewHolder>() {

    val repositoryList = mutableListOf<RepositoryData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(repositoryList[position])
    }

    override fun getItemCount(): Int = repositoryList.size


    class FollowerViewHolder(
        private val binding: ItemRepositoryListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: RepositoryData) {
            binding.repositoryTitleTv.text = data.title
            binding.repositoryPartTv.text = data.part
        }

    }


}