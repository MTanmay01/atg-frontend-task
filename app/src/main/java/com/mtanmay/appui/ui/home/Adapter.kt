package com.mtanmay.appui.ui.home

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.mtanmay.Post
import com.mtanmay.appui.databinding.PostCardBinding

class Adapter(
    private val context: Context,
    private var posts: List<Post>? = null,
    private val listener: OnItemClickListener
) : ListAdapter<Post, Adapter.ViewHolder>(DIFF_UTIL_CALLBACK) {

    companion object {
        private val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(posts != null)
            holder.bind(posts!![position])
    }

    override fun getItemCount(): Int = posts!!.size

    fun setData(postsList: List<Post>) {
        posts = postsList
        notifyItemInserted(posts!!.size)
    }

    inner class ViewHolder(
        private val binding: PostCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener() {
                val position = adapterPosition
                if(position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(posts!![position])
                }
            }
        }

        fun bind(post: Post) {
            binding.apply {

                if(post.imgUrl == null) {
                    binding.postImage.visibility = View.GONE
                    binding.questionerProfileImg.updateLayoutParams<ConstraintLayout.LayoutParams> {
                        topToBottom = binding.more.id
                    }
                }
                else {
                    Glide.with(context)
                        .load(post.imgUrl)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .centerCrop()
                        .into(postImage)
                }

                binding.questionerUsername.text = post.questionerUsername
                binding.questionerLocation.text = post.questionerLocation
                binding.questionerPostTime.text = post.questionerPostTime
                binding.question.text = post.question

                binding.answererUsername.text = post.answererUsername
                binding.answererPostTime.text = post.answererPostTime
                binding.answer.text = post.answer

            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(post: Post)
    }
}