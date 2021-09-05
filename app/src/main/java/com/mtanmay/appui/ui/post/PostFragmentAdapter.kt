package com.mtanmay.appui.ui.post

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mtanmay.Post
import com.mtanmay.appui.databinding.PostAnswerLayoutBinding

class PostFragmentAdapter(
    private val answers: List<Post.Answers>? = null
): ListAdapter<Post.Answers, PostFragmentAdapter.ViewHolder>(DIFF_UTIL_CALLBACK) {

    companion object {
        private val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Post.Answers>() {
            override fun areItemsTheSame(oldItem: Post.Answers, newItem: Post.Answers): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Post.Answers, newItem: Post.Answers): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostAnswerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("TAG", "onBindViewHolder: viewholder bound")
        if(answers != null) {
            Log.d("TAG", "onBindViewHolder: ANSWER USERNAME: ${answers[position].username}")
            holder.bind(answers[position])
        }
        else
            Log.d("TAG", "onBindViewHolder: No answers received")
    }

    override fun getItemCount(): Int {
        return answers!!.size
    }

    class ViewHolder(
        private val binding: PostAnswerLayoutBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(answer: Post.Answers) {

            binding.apply {

                username.text = answer.username
                postTime.text = answer.postTime
                postedAnswer.text = answer.answer
            }

        }

    }

}