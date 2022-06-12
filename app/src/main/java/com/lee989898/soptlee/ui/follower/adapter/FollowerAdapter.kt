package com.lee989898.soptlee.ui.follower.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lee989898.soptlee.databinding.ItemFollowerListBinding
import com.lee989898.soptlee.ui.detail.DetailActivity
import com.lee989898.soptlee.ui.follower.data.FollowerData

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    private val _followerData = mutableListOf<FollowerData>()
    var followerData: List<FollowerData> = _followerData
        set(value) {
            _followerData.clear()
            _followerData.addAll(value)
            notifyDataSetChanged()
        }

    fun deleteItem(i: Int) {
        _followerData.removeAt(i)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {

        holder.bind(_followerData[position])


    }

    override fun getItemCount(): Int = _followerData.size

    class FollowerViewHolder(
        private val binding: ItemFollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {

        }

        fun bind(followerData: FollowerData) {
            binding.followerRecycler = followerData

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailActivity::class.java)
                intent.putExtra("name", followerData.name)
                intent.putExtra("image", followerData.image)
                ContextCompat.startActivity(itemView.context, intent, null)
            }
        }
    }
}