package com.mtanmay.appui

import com.mtanmay.Post

class PostsData {

    companion object {

        private val post1 = Post(
            "Abhinav",
            "2 Days Ago",
            "Marathahalli",
            "Where can i get hot water bag for body relief pain in marathahalli?",
            "Paramar",
            "2 Days Ago",
            "At Apollo pharmacy, you can get hot and cold gel bag. You can put the bag in boiling water to heat and then use it for you pains.",
            answers =
            arrayListOf<Post.Answers>(
                Post.Answers(
                    "Paramar",
                    "2 Days Ago",
                    "At Apollo pharmacy, you can get hot and cold gel bag. You can put the bag in boiling water to heat and then use it for you pains."
                ),
                Post.Answers(
                    "Hemant",
                    "2 Days Ago",
                    "proven method"
                ),
                Post.Answers(
                    "Prakash",
                    "2 Days Ago",
                    "Yes right.."
                )
            )
        )

        private val post2 = Post(
            "Abhinav",
            "2 Days Ago",
            "Marathahalli",
            "Any one knows any good shops for metal frame bed in and around Marathahalli?",
            "Paramar",
            "2 Days Ago",
            "You can check HomeTown, they have good options of metal beds",
            answers =
            arrayListOf<Post.Answers>(
                Post.Answers(
                    "Paramar",
                    "2 Days Ago",
                    "You can check HomeTown, they have good options of metal beds"
                ),
                Post.Answers(
                    "Hemant",
                    "2 Days Ago",
                    "its the best place here"
                ),
                Post.Answers(
                    "Prakash",
                    "2 Days Ago",
                    "I don't like hometown shops"
                )
            )
        )

        private val post3 = Post(
            "Abhinav",
            "2 Days Ago",
            "Marathahalli",
            "Enjoy whenever you can",
            "Paramar",
            "2 Days Ago",
            "I miss this..",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8VEPshICGplVhkdwHpxzZblYvXfPCztl_-Q&usqp=CAU",
            answers =
            arrayListOf<Post.Answers>(
                Post.Answers(
                    "Paramar",
                    "2 Days Ago",
                    "i want to go too.."
                ),
                Post.Answers(
                    "Hemant",
                    "2 Days Ago",
                    "wow this looks good"
                ),
                Post.Answers(
                    "Prakash",
                    "2 Days Ago",
                    "i'm too lazy to go outside"
                )
            )
        )

        private val post4 = Post(
            "Abhinav",
            "2 Days Ago",
            "Marathahalli",
            "I'm a freelance photographer and new to bangalore, looking for carrier opportunities here, can anyone suggest how to find some?",
            "Paramar",
            "2 Days Ago",
            "If you're looking for career in photography then I'm sorry to inform that there isn't much scope here because the supply is much higher than demand. 1 in every 20 college students are into photography and most of them resort to instagrams pages to earn some extra buck",
            answers =
            arrayListOf<Post.Answers>(
                Post.Answers(
                    "Paramar",
                    "2 Days Ago",
                    "If you're looking for career in photography then I'm sorry to inform that there isn't much scope here because the supply is much higher than demand. 1 in every 20 college students are into photography and most of them resort to instagrams pages to earn some extra buck"
                ),
                Post.Answers(
                    "Hemant",
                    "2 Days Ago",
                    "i dont anything about this"
                ),
                Post.Answers(
                    "Prakash",
                    "2 Days Ago",
                    "i knew some places but don't remember right now"
                )
            )
        )

        private val post5 = Post(
            "Abhinav",
            "2 Days Ago",
            "Marathahalli",
            "This was a great trip",
            "Paramar",
            "2 Days Ago",
            "omg wow! how did you not fall lol",
            "https://img.traveltriangle.com/blog/wp-content/uploads/2018/09/mt.-cook-cover.jpg",
            answers =
            arrayListOf<Post.Answers>(
                Post.Answers(
                    "Paramar",
                    "2 Days Ago",
                    "omg wow! how did you not fall lol"
                ),
                Post.Answers(
                    "Hemant",
                    "2 Days Ago",
                    "man this is both scary and fun at the same time"
                ),
                Post.Answers(
                    "Prakash",
                    "2 Days Ago",
                    "yea.. great place to fall off from"
                )
            )
        )

        fun getData(): ArrayList<Post> {

            val posts = ArrayList<Post>()
            posts.add(post1)
            posts.add(post2)
            posts.add(post3)
            posts.add(post4)
            posts.add(post5)
            posts.add(post1)
            posts.add(post2)
            posts.add(post3)
            posts.add(post4)
            posts.add(post5)

            return posts
        }
    }



}