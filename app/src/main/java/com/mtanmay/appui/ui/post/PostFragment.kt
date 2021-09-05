package com.mtanmay.appui.ui.post

import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.mtanmay.appui.R
import com.mtanmay.appui.databinding.FragmentPostBinding

class PostFragment : Fragment(R.layout.fragment_post) {

    private val arguments by navArgs<PostFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentPostBinding.bind(view)
        val post = arguments.item

        val adapter = PostFragmentAdapter(post.answers)

        binding.apply {

            answersRcv.setHasFixedSize(true)
            answersRcv.layoutManager = LinearLayoutManager(context)
            answersRcv.adapter = adapter

            answersRcv.setOnClickListener() {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
            }

            if(post.imgUrl != null) {
                Glide.with(this@PostFragment)
                    .load(post.imgUrl)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(postImage)
            }
            else {
                postImage.visibility = View.GONE
                optionClose.visibility = View.GONE
                questionerProfileImg.updateLayoutParams<ConstraintLayout.LayoutParams> {
                    topToTop = root.id
                    topMargin = 40
                }

            }

            questionerUsername.text = post.questionerUsername
            questionerPostTime.text = post.questionerPostTime
            questionerLocation.text = post.questionerLocation
            question.text = post.question

        }
    }
}