package com.lee989898.soptlee.ui.follower

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.FragmentFollowerBinding
import com.lee989898.soptlee.ui.follower.adapter.FollowerAdapter
import com.lee989898.soptlee.ui.follower.viewmodel.FollowerViewModel
import com.lee989898.soptlee.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FollowerFragment : BindingFragment<FragmentFollowerBinding>(R.layout.fragment_follower) {

    private lateinit var followerAdapter: FollowerAdapter
    private val followerViewModel by viewModels<FollowerViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        followerViewModel.getGithubFollower()
        initFollowerAdapter()
        observeData()
    }

    private fun initFollowerAdapter() {
        followerAdapter = FollowerAdapter()
        binding.followerListRv.adapter = followerAdapter
//
//        val swipeGesture = object : SwipeGesture(requireContext()) {
//            override fun onMove(
//                recyclerView: RecyclerView,
//                viewHolder: RecyclerView.ViewHolder,
//                target: RecyclerView.ViewHolder
//            ): Boolean {
//
//                val fromPos = viewHolder.adapterPosition
//                val toPos = target.adapterPosition
//
//                Collections.swap(list, fromPos, toPos)
//                followerAdapter.notifyItemMoved(fromPos, toPos)
//
//                return false
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                when (direction) {
//                    ItemTouchHelper.LEFT -> {
//                        followerAdapter.deleteItem(viewHolder.adapterPosition)
//                    }
//                }
//
//            }
//
//        }
//
//        val touchHelper = ItemTouchHelper(swipeGesture)
//        touchHelper.attachToRecyclerView(binding.followerListRv)
    }


    private fun observeData() {
        followerViewModel.followData.observe(viewLifecycleOwner) {
            followerAdapter.followerData = it
        }
    }
}