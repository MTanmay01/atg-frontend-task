package com.mtanmay.appui.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mtanmay.Post
import com.mtanmay.appui.PostsData
import com.mtanmay.appui.R
import com.mtanmay.appui.databinding.FragmentHomeBinding

private const val TAG = "Home"

class Home : Fragment(R.layout.fragment_home), Adapter.OnItemClickListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var posts: ArrayList<Post>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)

        posts = PostsData.getData()
        val mAdapter = Adapter(requireContext(), posts, this)

        binding.apply {

            postsRcv.setHasFixedSize(true)
            postsRcv.layoutManager = LinearLayoutManager(context)
            postsRcv.adapter = mAdapter
        }

    }

    override fun onItemClick(post: Post) {
        val action = HomeDirections.actionHomeToPost(post)
        findNavController().navigate(action)
    }

}