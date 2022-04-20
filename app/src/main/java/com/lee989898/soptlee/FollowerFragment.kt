package com.lee989898.soptlee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.lee989898.soptlee.databinding.FragmentFollowerBinding
import java.util.*

class FollowerFragment : Fragment() {

    private lateinit var followerAdapter: FollowerAdapter
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    lateinit var list: List<FollowerData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        list = listOf(
            FollowerData("이강민", "안드로이드 파트장"),
            FollowerData("김태현", "IOS 파트장"),
            FollowerData("김두범", "기획 파트장"),
            FollowerData("권혁진", "웹 파트장"),
            FollowerData("채정아", "서버 파트장"),
            FollowerData("박수아", "디자인 파트장")
        )
        initFollowerAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initFollowerAdapter() {
        followerAdapter = FollowerAdapter()

        val swipeGesture = object : SwipeGesture(requireContext()){

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {

                val from_pos = viewHolder.adapterPosition
                val to_pos = target.adapterPosition

                Collections.swap(list,from_pos, to_pos)
                followerAdapter.notifyItemMoved(from_pos, to_pos)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when(direction) {
                    ItemTouchHelper.LEFT -> {
                        followerAdapter.deleteItem(viewHolder.adapterPosition)
                    }
                    ItemTouchHelper.RIGHT -> {
                        followerAdapter.deleteItem(viewHolder.adapterPosition)
                    }
                }

            }

        }

        val touchHelper = ItemTouchHelper(swipeGesture)
        touchHelper.attachToRecyclerView(binding.followerListRv)

        binding.followerListRv.adapter = followerAdapter

        val dividerItemDecoration =
            DividerItemDecoration(binding.followerListRv.context, LinearLayoutManager(requireContext()).orientation)

        binding.followerListRv.addItemDecoration(dividerItemDecoration)

        followerAdapter.followerList.addAll(
            list
        )
        followerAdapter.notifyDataSetChanged()
    }

}