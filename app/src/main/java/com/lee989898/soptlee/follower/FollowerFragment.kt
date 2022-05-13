package com.lee989898.soptlee.follower

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.*
import com.lee989898.soptlee.SwipeGesture
import com.lee989898.soptlee.databinding.FragmentFollowerBinding
import com.lee989898.soptlee.github.GitHubService
import com.lee989898.soptlee.github.ResponseGitHubFollowerItem
import com.lee989898.soptlee.retrofit.GitHubRetrofitInstance
import retrofit2.Response
import java.util.*

class FollowerFragment : Fragment() {

    private lateinit var followerAdapter: FollowerAdapter
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    var list = mutableListOf<FollowerData>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        getGitHubFollower()
        initFollowerAdapter()

        return binding.root
    }

    private fun initFollowerAdapter() {
        followerAdapter = FollowerAdapter()
        binding.followerListRv.adapter = followerAdapter

        val swipeGesture = object : SwipeGesture(requireContext()) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                val fromPos = viewHolder.adapterPosition
                val toPos = target.adapterPosition

                Collections.swap(list, fromPos, toPos)
                followerAdapter.notifyItemMoved(fromPos, toPos)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.LEFT -> {
                        followerAdapter.deleteItem(viewHolder.adapterPosition)
                    }
//                    ItemTouchHelper.RIGHT -> {
//                        followerAdapter.deleteItem(viewHolder.adapterPosition)
//                    }
                }

            }

        }

        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(binding.followerListRv)

        followerAdapter.followerList.addAll(list)
        followerAdapter.notifyDataSetChanged()


    }

    private fun getGitHubFollower() {
        val retService = GitHubRetrofitInstance.getRetrofitInstance().create(GitHubService::class.java)

        val pathResponse: LiveData<Response<List<ResponseGitHubFollowerItem>>> = liveData {
            val response = retService.getGithubFollower("lee989898")
            emit(response)
        }

        pathResponse.observe(viewLifecycleOwner) {
            for (i in 0 until it.body()!!.size) {
                list.add(
                    FollowerData(
                        it.body()?.get(i)?.login.toString(),
                        it.body()?.get(i)?.avatar_url.toString()
                    )
                )
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}