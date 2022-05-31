package com.lee989898.soptlee.follower.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lee989898.soptlee.databinding.ItemFollowerListBinding
import com.lee989898.soptlee.detail.DetailActivity
import com.lee989898.soptlee.follower.data.FollowerData

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    private val _data = mutableListOf<FollowerData>()
    var data: List<FollowerData> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    fun deleteItem(i: Int) {
        _data.removeAt(i)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {

        holder.bind(_data[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("name", _data[position].name)
            intent.putExtra("image", _data[position].image)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
    }

    override fun getItemCount(): Int = _data.size

    class FollowerViewHolder(
        private val binding: ItemFollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {

            }
        }

        fun bind(data: FollowerData) {
            binding.followerRecycler = data
        }
    }
}