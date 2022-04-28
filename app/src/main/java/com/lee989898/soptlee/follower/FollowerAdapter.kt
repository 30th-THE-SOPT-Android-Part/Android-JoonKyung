package com.lee989898.soptlee.follower

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lee989898.soptlee.databinding.ItemFollowerListBinding
import com.lee989898.soptlee.detail.DetailActivity

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    val followerList = mutableListOf<FollowerData>()

    fun deleteItem(i: Int){

        followerList.removeAt(i)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("name", followerList[position].name)
            intent.putExtra("introduction", followerList[position].introduction)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }


//        val layoutParams = holder.itemView.layoutParams
//        layoutParams.height = 500
//        holder.itemView.requestLayout()


    }

    override fun getItemCount(): Int = followerList.size


    class FollowerViewHolder(
        private val binding: ItemFollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {

            }
        }

        fun onBind(data: FollowerData) {
            binding.followerNameTv.text = data.name
            binding.followerIntroduceTv.text = data.introduction
        }




    }
}