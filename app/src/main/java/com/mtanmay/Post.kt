package com.mtanmay

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import org.jetbrains.annotations.NonNls

@Parcelize
data class Post(

//    @ColumnInfo(name = "questioner_username")
    val questionerUsername: String,

//    @ColumnInfo(name = "questioner_post_time")
    val questionerPostTime: String,

//    @ColumnInfo(name = "questioner_location")
    val questionerLocation: String,

//    @ColumnInfo(name = "question")
    val question: String,

//    @ColumnInfo(name = "answerer_username")
    val answererUsername: String,

//    @ColumnInfo(name = "answerer_post_time")
    val answererPostTime: String,

//    @ColumnInfo(name = "answer")
    val answer: String,

//    @ColumnInfo(name = "img_url")
    val imgUrl: String? = null,

    val answers: ArrayList<Answers>,

//    @NonNull
//    @PrimaryKey()
    val id: String = questionerUsername+questionerPostTime+question

): Parcelable {

    @Parcelize
    data class Answers (
        val username: String,
        val postTime: String,
        val answer: String,
        val id: String = username+postTime+answer
    ): Parcelable

}