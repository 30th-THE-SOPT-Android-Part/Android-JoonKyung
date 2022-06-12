package com.lee989898.soptlee.ui.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lee989898.soptlee.databinding.ItemRepositoryListBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.FollowerViewHolder>() {

    private val _data = mutableListOf<RepositoryData>()
    var data: List<RepositoryData> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemRepositoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    override fun getItemCount(): Int = _data.size

    class FollowerViewHolder(
        private val binding: ItemRepositoryListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: RepositoryData) {
            binding.repositoryRecycler = data
        }
    }
}